#!/bin/bash
# $1 Language (e.g. 'fr'). Note: this script is useless for english.
LANGUAGE=$1
grep 'http://dbpedia.org/resource/' interlanguage_links_$LANGUAGE.nt > interlanguage_links_$LANGUAGE_en.nt
sort -b -k 3 -t ' ' interlanguage_links_$LANGUAGE_en.nt > interlanguage_links_$LANGUAGE_en_sorted.nt
sort -b -k 1b,1 -t ' ' yago_types.nt > yago_types_sorted.nt
join -t ' ' -o 1.1,2.2,2.3,2.4 -1 3 -2 1 interlanguage_links_$LANGUAGE_en_sorted.nt yago_types_sorted.nt > yago_types_$LANGUAGE.nt
# then manually concat yago_types_XX.nt to instance_types.nt
