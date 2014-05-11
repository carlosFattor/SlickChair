package controllers

import play.api.mvc.{ RequestHeader, Request }
import play.api.templates.{ Html, Txt }
import play.api.{ Logger, Plugin, Application }
import securesocial.core.{ SocialUser, SecuredRequest }
import play.api.data.Form
import securesocial.controllers.Registration.RegistrationInfo
import securesocial.controllers.PasswordChange.ChangeInfo
import securesocial.controllers.DefaultTemplatesPlugin
import controllers.LoginWrapper.loginWrapperForm
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB
import models.Topics
import org.joda.time.DateTime
import models.PersonRole._

class LoginTemplates(application: Application) extends DefaultTemplatesPlugin(application) {
  override def getLoginPage[A](implicit request: Request[A], form: Form[(String, String)], errorMessage: Option[String] = None): Html = {
    views.html.login(
      form.value match {
        case Some((username, password)) =>
          loginWrapperForm.fillAndValidate(LoginWrapperForm(username, password, false))  
        case None =>
          loginWrapperForm
      },
      errorMessage
    )
  }

  // override def getStartSignUpPage[A](implicit request: Request[A], form: Form[String]): Html = {
  //   securesocial.views.html.Registration.startSignUp(form)
  // }
  
  override def getSignUpPage[A](implicit request: Request[A], form: Form[RegistrationInfo], token: String): Html = {
    views.html.emailSignUp(form, token)
  }

  // override def getStartResetPasswordPage[A](implicit request: Request[A], form: Form[String]): Html = {
  //   securesocial.views.html.Registration.startResetPassword(form)
  // }

  override def getResetPasswordPage[A](implicit request: Request[A], form: Form[(String, String)], token: String): Html = {
    views.html.resetPasswordPage(form, token)
  }

  // override def getPasswordChangePage[A](implicit request: SecuredRequest[A], form: Form[ChangeInfo]):Html = {
  //   securesocial.views.html.passwordChange(form)
  // }

  override def getNotAuthorizedPage[A](implicit request: Request[A]): Html = {
    views.html.main("Not Authorized")(
      Html("You are not authorized to access that page."))
  }

  // override def getSignUpEmail(token: String)(implicit request: RequestHeader): (Option[Txt], Option[Html]) = {
  //   (None, Some(securesocial.views.html.mails.signUpEmail(token)))
  // }

  // override def getAlreadyRegisteredEmail(user: Identity)(implicit request: RequestHeader): (Option[Txt], Option[Html]) = {
  //   (None, Some(securesocial.views.html.mails.alreadyRegisteredEmail(user)))
  // }

  // override def getWelcomeEmail(user: Identity)(implicit request: RequestHeader): (Option[Txt], Option[Html]) = {
  //   (None, Some(securesocial.views.html.mails.welcomeEmail(user)))
  // }

  // override def getUnknownEmailNotice()(implicit request: RequestHeader): (Option[Txt], Option[Html]) = {
  //   (None, Some(securesocial.views.html.mails.unknownEmailNotice(request)))
  // }

  // override def getSendPasswordResetEmail(user: Identity, token: String)(implicit request: RequestHeader): (Option[Txt], Option[Html]) = {
  //   (None, Some(securesocial.views.html.mails.passwordResetEmail(user, token)))
  // }

  // override def getPasswordChangedNoticeEmail(user: Identity)(implicit request: RequestHeader): (Option[Txt], Option[Html]) = {
  //   (None, Some(securesocial.views.html.mails.passwordChangedNotice(user)))
  // }
}
