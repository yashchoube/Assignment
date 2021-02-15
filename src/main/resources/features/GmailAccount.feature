Feature: GmailAccount

Scenario: Compose email using Gmail.
  When User on gmail
  And User SignIn in gmail
  And User Composes email
  And User filled details for email
  Then Verify email is sent successfully