mustached-adventure
===================

An idea for a project to better learn Scala.... no real business or functional value intended

Purpose: To allow a community of users to openly share a single "financial" account

### Ideas...
1. One single account with multiple "views"
   * a community of users is organized around this single account
1. Multiple users can make deposits into multiple views
   * deposits are unrestricted
1. all users see current ballance of each view and total ballance of account
  * views can have negative balances
  * the total account ballance must always be greater than zero
  * the total balance of all views equals the total balance of the account
1. withdrawls made by users are automatically applied to their "view"
  * multiple users may withdrawl from a single view
  * no user may withdrawl from more than one view
1. All users may see all account activity
1. Users who's view is consistently a negative value are banned from the system (no one likes a freeloader... except politicians who need votes and have access to other people's money)
1. Various analytics should show transaction history according to:
  * view
  * who makes deposits
  * who makes withdrawals
  * where the funds go
