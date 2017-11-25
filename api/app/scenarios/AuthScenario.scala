package scenarios

import javax.inject.Inject

import models.domain.AuthInfo
import models.views.SignUpCommand
import play.api.libs.json.JsValue
import play.api.mvc.Request
import repositories.RDB
import services.{ SessionService, UserService }
import syntax.{ AbstractDBIOInstances, DBResult, Result }

import scala.concurrent.ExecutionContext

class AuthScenario @Inject()(
  userService: UserService,
  sessionService: SessionService,
  implicit val rdb: RDB
) (
  implicit
  val ec: ExecutionContext
) extends AbstractDBIOInstances {

  def signUp(signUpCommand: SignUpCommand): Result[Unit] = {
    val result: DBResult[Unit] = for {
      _ <- userService.checkExistsEmail(signUpCommand.email)
      userId <- userService.create(signUpCommand)
      user <- userService.findById(userId)
      _ <- DBResult(sessionService.create(user))
    } yield ()
    rdb.exec(result)
  }

  def signIn(authInfo: AuthInfo)(implicit req: Request[JsValue]): Result[Unit] = {
    val result: DBResult[Unit] = for {
      _ <- DBResult(sessionService.checkExistsSession)
      user <- userService.findByAuthInfo(authInfo)
      _ <- DBResult(sessionService.create(user))
    } yield ()
    rdb.exec(result)
  }
}
