package org.millarts.groovy.text

import org.atteo.evo.inflector.English

/**
 * This class enhances strings by adding a plural() method
 * that returns the plural inflection for a word.
 *
 * @since 0.1.0
 */
class PluralizeExtension {
  static String plural(final String self, int cardinality = 2) {
    English.plural(self, cardinality)
  }
}
