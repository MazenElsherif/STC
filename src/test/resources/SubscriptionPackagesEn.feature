@English
Feature: Subscription Package Validation

  Scenario: Validate Subscription Packages for Saudi Arabiaa (SA)
    Given I am on the subscription service website
    Then I should see the following subscription packages:
      | Package Type | Price | Currency |Discovery| Video quality|Device access|ReWind|
      | lite        | 15    | SAR/month| Included|HD  |         4   |For Up to 14 days |
      | classic      | 25   | SAR/month|Included | Full HD |     4  |For Up to 14 days|
      | premium     | 60   | SAR/month| Included |4K UHD  |       8 |For Up to 14 days|

  Scenario: Validate Subscription Packages for Kuwait
    Given I am on the subscription service website
    When I select "Kuwait" as the country
    Then I should see the following subscription packages:
      | Package Type | Price | Currency |Discovery| Video quality|Device access|ReWind|
      | lite        | 1.2     | KWD/month| Included|HD  |         4   |for 14 Day |
      | classic      | 2.5    | KWD/month|Included | Full HD |     4  |For 14 days|
      | premium     | 4.8    | KWD/month|Included |4K UHD  |       8 |For 14 days|

  Scenario: Validate Subscription Packages for Bahrain
    Given I am on the subscription service website
    When I select "Bahrain" as the country
    Then I should see the following subscription packages:
      | Package Type | Price | Currency |Discovery| Video quality|Device access|ReWind|
      | lite        | 2     | BHD/month| Included|HD  |         4   |for 14 Day |
      | classic      | 3    | BHD/month|Included | Full HD |     4  |For 14 days|
      | premium     | 6    | BHD/month|Included |4K UHD  |       8 |For 14 days|
# will fail due to wrong conversion in curencies
  Scenario: Verify Currency Conversion
    Given I am on the subscription service website
    When should see the correct converted prices based on exchange rates From SAR to KWD
    Then I should see the correct converted prices based on exchange rates From SAR to BHD

