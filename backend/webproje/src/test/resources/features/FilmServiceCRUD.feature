Feature: Film icin CRUD islemleri yapilabilmelidir.

  Scenario: film eklenebilmelidir
    When "yeni bir film" bir film eklenmelidir
    Then "yeni bir film" ile film eklenmis olmalidir

  Scenario: film adiyla silinebilmelidir
    Given "yeni bir film" adinda bir film olmalidir
    When "yeni bir film" film silinmelidir
    Then "yeni bir film" film bulunamamalidir

  Scenario: film guncellenebilmelidir
    Given "yeni bir film" adinda bir film olmalidir
    When "yeni bir film", film adi "guncellenenFilmAdi" ile guncellenmelidir
    Then "guncellenenFilmAdi" ile film bulunmalidir

    Scenario: filmler listelenebilmelidir
      Given film tablosu bos olmamalidir
      Then filmler listelenebilmelidir