package org.millarts.groovy.text

import spock.lang.*

/**
 * Because this extension is so simple, there is not much to test.
 * The tests here are basic smoke / sanity checks.
 * The tests for evo-inflector are pretty extensive.
 */
class PluralizeExtensionSpec extends Specification {

  void 'bare extension works'() {
    expect:
    PluralizeExtension.plural('bird')    == 'birds'
    PluralizeExtension.plural('bird', 1) == 'bird'
  }


  @Unroll
  void "The plural of #{word} is #{plural}"() {
    expect: word.plural() == plural

    where:
    word         | plural
      'car'      | 'cars'
      'Bison'    | 'Bison'
      'sugar'    | 'sugar'
      'CHILD'    | 'Children'  // Probably not the desired behavior
      'man'      | 'men'
      'tooth'    | 'teeth'
      'mouse'    | 'mice'
      'life'     | 'lives'
      'Life'     | 'Lives'
      'codex'    | 'codices'
      'foot'     | 'feet'
      'mustache' | 'mustaches'
      'goose'    | 'geese'
      'ox'       | 'oxen'
  }


  void 'I can specify the cardinality for the inflection'() {
    expect:
    'bird'.plural(0)    == 'bird'
    'bird'.plural(1)    == 'bird'
    'bird'.plural(2)    == 'birds'
    'bird'.plural(8000) == 'birds'
  }


  void 'I can pluralize GStrings'() {
    when:
    def type     = 'door'
    def creature = "${type}mouse"

    then:
    creature.class in GString

    and:
    creature.plural() == 'doormice'
  }

}
