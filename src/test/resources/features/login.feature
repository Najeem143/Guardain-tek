Background:
    Given User is on retail website homepage
    When User click on the login link

 

@login
Scenario: Verify user is able to login to tek retail website
    And User enter email 'guardianscucumber@gmail.com' and password 'Guardians@123'
    And User click on login button
    Then Verify user is logged in

@register
Scenario Outline: Verify user is able to register with tek retail website
    And User click on create new account link
    And User enter '<name>' and '<email>' and '<password>' and '<confPassword>'
    And User click on singup button
    Then Verify user account is created

Examples:
|name|email|password|confPassword|
|guardians|guardianscucumber1@gmail.com|Guardians345$|Guardians345$|
|guardians|guardianscucumber2@gmail.com|Guardians345$|Guardians345$|
|guardians|guardianscucumber3@gmail.com|Guardians345$|Guardians345$|