package modules

import com.google.inject.AbstractModule
import infrastructure.jdbc.slick.transaction.{ SlickTransactionBuilder, SlickTransactionRunner }
import infrastructure.jdbc.slick.UserRepositorySlick
import play.api.{ Configuration, Environment }
import repositories.transaction.{ TransactionBuilder, TransactionRunner }
import repositories.UserRepository

class SlickDBModule(environment: Environment, configuration: Configuration) extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[TransactionRunner]).to(classOf[SlickTransactionRunner])
    bind(classOf[TransactionBuilder]).to(classOf[SlickTransactionBuilder])
    bind(classOf[UserRepository]).to(classOf[UserRepositorySlick])
  }
}
