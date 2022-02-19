Feature:

  Scenario Outline: id ile aktor listelenebilmeli
    When "<aktorAdi>" adindaki aktorerin sayisi getirilmelidir
    Then "<aktorSayisi>" tane aktor bulunmalidir.
    Examples:
      | aktorAdi  | aktorSayisi |
      | Christian | 3           |
      | Kenneth   | 4           |
      | Tim       | 1           |
      | Uma       | 1           |
      | Susan     | 2           |
