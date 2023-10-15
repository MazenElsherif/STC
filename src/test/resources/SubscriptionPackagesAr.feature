@Arabic
Feature: Subscription Package Validation
  Scenario: Validate Subscription Packages for Saudi Arabiaa (SA)
    Given I am on the subscription service website
    Given Change Langauge To Arabic
    Then I should see the following subscription packages:
      | Package Type | Price | Currency |Discovery| Video quality|Device access|ReWind|
      | لايت        | 15    |  ريال سعودي/شهر| شامل|HD  |         4   |لغاية 14 يوم |
      | الأساسية      | 25   |  ريال سعودي/شهر|شامل | Full HD |     4  |لغاية 14 يوم|
      | بريميوم     | 60   |  ريال سعودي/شهر| شامل |4K UHD  |       8 |لغاية 14 يوم |

