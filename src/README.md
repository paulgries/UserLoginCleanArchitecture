# Account management

User can
- create account
  - requires username, password
  - confirms that account was created, does not log in
- log in
  - requires username, password
  - results in "you are logged in" screen with "change password" and "log out"
- change password
  - requires old password, new password
  - results in "your password was changed" message, stays logged in
- log out

Notes:
- can only create account if not logged into an account
- can only log in if not logged into an account
- can only log out if logged into an account
- can only change password if logged into an account, and it affects the current account
- accounts are persistent


# Entities

- Account
- Current account
- 

## Use cases

1. CreateAccountInteractor
   - CreateAccountInteractor(IOutputPort presenter, AccountLookupTable lookupTable)
   - Success:
     - Creates new account (does not yet log in)
   - Failure:
     -  
2. LoginInteractor
   - Input: account name, password
   - Success:
     - account becomes active
   - Failure:
     - account name does not exist
     - password incorrect
3. LogoutInteractor
4. ChangePasswordInteractor