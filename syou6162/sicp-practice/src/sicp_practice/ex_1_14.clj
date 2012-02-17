(ns sicp-practice.ex-1-14
  (:use [sicp-practice.1-2]))

(with-redefs [first-denomination (fn [kinds-of-coins]
				   (cond (= kinds-of-coins 1) 1
					 (= kinds-of-coins 2) 5
					 (= kinds-of-coins 3) 10))]
  (cc 11 3)) ; 4

(use 'clojure.tools.trace)
(dotrace [cc] (cc 11 3))

;; TRACE t1960: (cc 11 3)
;; TRACE t1961: | (cc 11 2)
;; TRACE t1962: | | (cc 11 1)
;; TRACE t1963: | | | (cc 11 0)
;; TRACE t1963: | | | => 0
;; TRACE t1964: | | | (cc 10 1)
;; TRACE t1965: | | | | (cc 10 0)
;; TRACE t1965: | | | | => 0
;; TRACE t1966: | | | | (cc 9 1)
;; TRACE t1967: | | | | | (cc 9 0)
;; TRACE t1967: | | | | | => 0
;; TRACE t1968: | | | | | (cc 8 1)
;; TRACE t1969: | | | | | | (cc 8 0)
;; TRACE t1969: | | | | | | => 0
;; TRACE t1970: | | | | | | (cc 7 1)
;; TRACE t1971: | | | | | | | (cc 7 0)
;; TRACE t1971: | | | | | | | => 0
;; TRACE t1972: | | | | | | | (cc 6 1)
;; TRACE t1973: | | | | | | | | (cc 6 0)
;; TRACE t1973: | | | | | | | | => 0
;; TRACE t1974: | | | | | | | | (cc 5 1)
;; TRACE t1975: | | | | | | | | | (cc 5 0)
;; TRACE t1975: | | | | | | | | | => 0
;; TRACE t1976: | | | | | | | | | (cc 4 1)
;; TRACE t1977: | | | | | | | | | | (cc 4 0)
;; TRACE t1977: | | | | | | | | | | => 0
;; TRACE t1978: | | | | | | | | | | (cc 3 1)
;; TRACE t1979: | | | | | | | | | | | (cc 3 0)
;; TRACE t1979: | | | | | | | | | | | => 0
;; TRACE t1980: | | | | | | | | | | | (cc 2 1)
;; TRACE t1981: | | | | | | | | | | | | (cc 2 0)
;; TRACE t1981: | | | | | | | | | | | | => 0
;; TRACE t1982: | | | | | | | | | | | | (cc 1 1)
;; TRACE t1983: | | | | | | | | | | | | | (cc 1 0)
;; TRACE t1983: | | | | | | | | | | | | | => 0
;; TRACE t1984: | | | | | | | | | | | | | (cc 0 1)
;; TRACE t1984: | | | | | | | | | | | | | => 1
;; TRACE t1982: | | | | | | | | | | | | => 1
;; TRACE t1980: | | | | | | | | | | | => 1
;; TRACE t1978: | | | | | | | | | | => 1
;; TRACE t1976: | | | | | | | | | => 1
;; TRACE t1974: | | | | | | | | => 1
;; TRACE t1972: | | | | | | | => 1
;; TRACE t1970: | | | | | | => 1
;; TRACE t1968: | | | | | => 1
;; TRACE t1966: | | | | => 1
;; TRACE t1964: | | | => 1
;; TRACE t1962: | | => 1
;; TRACE t1985: | | (cc 6 2)
;; TRACE t1986: | | | (cc 6 1)
;; TRACE t1987: | | | | (cc 6 0)
;; TRACE t1987: | | | | => 0
;; TRACE t1988: | | | | (cc 5 1)
;; TRACE t1989: | | | | | (cc 5 0)
;; TRACE t1989: | | | | | => 0
;; TRACE t1990: | | | | | (cc 4 1)
;; TRACE t1991: | | | | | | (cc 4 0)
;; TRACE t1991: | | | | | | => 0
;; TRACE t1992: | | | | | | (cc 3 1)
;; TRACE t1993: | | | | | | | (cc 3 0)
;; TRACE t1993: | | | | | | | => 0
;; TRACE t1994: | | | | | | | (cc 2 1)
;; TRACE t1995: | | | | | | | | (cc 2 0)
;; TRACE t1995: | | | | | | | | => 0
;; TRACE t1996: | | | | | | | | (cc 1 1)
;; TRACE t1997: | | | | | | | | | (cc 1 0)
;; TRACE t1997: | | | | | | | | | => 0
;; TRACE t1998: | | | | | | | | | (cc 0 1)
;; TRACE t1998: | | | | | | | | | => 1
;; TRACE t1996: | | | | | | | | => 1
;; TRACE t1994: | | | | | | | => 1
;; TRACE t1992: | | | | | | => 1
;; TRACE t1990: | | | | | => 1
;; TRACE t1988: | | | | => 1
;; TRACE t1986: | | | => 1
;; TRACE t1999: | | | (cc 1 2)
;; TRACE t2000: | | | | (cc 1 1)
;; TRACE t2001: | | | | | (cc 1 0)
;; TRACE t2001: | | | | | => 0
;; TRACE t2002: | | | | | (cc 0 1)
;; TRACE t2002: | | | | | => 1
;; TRACE t2000: | | | | => 1
;; TRACE t2003: | | | | (cc -4 2)
;; TRACE t2003: | | | | => 0
;; TRACE t1999: | | | => 1
;; TRACE t1985: | | => 2
;; TRACE t1961: | => 3
;; TRACE t2004: | (cc 1 3)
;; TRACE t2005: | | (cc 1 2)
;; TRACE t2006: | | | (cc 1 1)
;; TRACE t2007: | | | | (cc 1 0)
;; TRACE t2007: | | | | => 0
;; TRACE t2008: | | | | (cc 0 1)
;; TRACE t2008: | | | | => 1
;; TRACE t2006: | | | => 1
;; TRACE t2009: | | | (cc -4 2)
;; TRACE t2009: | | | => 0
;; TRACE t2005: | | => 1
;; TRACE t2010: | | (cc -9 3)
;; TRACE t2010: | | => 0
;; TRACE t2004: | => 1
;; TRACE t1960: => 4
