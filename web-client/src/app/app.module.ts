import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import {
  MatButtonModule,
  MatCardModule,
  MatSidenavModule,
  MatInputModule,
  MatDialogModule
} from '@angular/material';

import { AppComponent } from './app.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';
import { TweetListComponent } from './components/tweet-list/tweet-list.component';
import { TweetCardComponent } from './components/tweet-card/tweet-card.component';
import { TweetFormComponent } from './components/tweet-form/tweet-form.component';
import { AccountFormComponent } from './components/account-form/account-form.component';
import { MockDbData } from './repository/mock-db/mock-db-data';
import { TweetHttpService } from "./repository/http/tweet/tweet-http.service";
import { TimelineComponent } from './components/timeline/timeline.component';
import { TimelineService } from './services/timeline/timeline.service';
import { SignInFormComponent } from './components/sign-in-form/sign-in-form/sign-in-form.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    SideBarComponent,
    TweetListComponent,
    TweetCardComponent,
    TweetFormComponent,
    AccountFormComponent,
    TimelineComponent,
    SignInFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    InMemoryWebApiModule.forRoot(MockDbData),
    HttpClientModule,
    MatButtonModule,
    MatCardModule,
    MatSidenavModule,
    MatInputModule,
    MatDialogModule
  ],
  providers: [TweetHttpService, TimelineService],
  bootstrap: [AppComponent],
  entryComponents: [SignInFormComponent]
})
export class AppModule {
}
