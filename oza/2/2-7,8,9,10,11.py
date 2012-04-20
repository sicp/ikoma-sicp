#!/usr/bin/env python 
# -*- coding: utf-8 -*-

class StribingZeroError(Exception):
	pass

class AssertionError(Exception):
	pass

class Interval:

	def __init__(self, a, b):
		self.interval = (float(min(a,b)), float(max(a,b)))

	# 2.7
	def lower_bound(self):
		return self.interval[0]

	# 2.7
	def upper_bound(self):
		return self.interval[1]

	def __add__(self, other):
		l = self.lower_bound() + other.lower_bound()
		u = self.upper_bound() + other.upper_bound()
		return Interval(l, u)

	# 2.8
	def __sub__(self, other):
		l = self.lower_bound() - other.lower_bound()
		u = self.upper_bound() - other.upper_bound()
		return Interval(l, u)


	def __mul__(self, other):
		xl = self.lower_bound()
		xu = self.upper_bound()
		yl = other.lower_bound()
		yu = other.upper_bound()

		if xl >= 0 and xu >= 0:
			if yl >= 0 and yu >= 0:
				l = xl * yl
				u = xu * yu
			elif yl < 0 and yu >= 0:
				l = xu * yl
				u = xu * yu
			elif yl < 0 and yu < 0:
				l = xu * yl
				u = xl * yu
		elif xl < 0 and xu >= 0:
			if yl >= 0 and yu >= 0:
				l = xl * yu
				u = xu * yu
			elif yl < 0 and yu >= 0:
				p1 = self.lower_bound() * other.lower_bound()
				p2 = self.lower_bound() * other.upper_bound()
				p3 = self.upper_bound() * other.lower_bound()
				p4 = self.upper_bound() * other.upper_bound()
				l = min(p1, p2, p3, p4)
				u = max(p1, p2, p3, p4)
			elif yl < 0 and yu < 0:
				l = xu * yl
				u = xl * yl
		elif xl < 0 and xu < 0:
			if yl >= 0 and yu >= 0:
				l = xl * yu
				u = xu * yl
			elif yl < 0 and yu >= 0:
				l = xl * yu
				u = xl * yl
			elif yl < 0 and yu < 0:
				l = xu * yu
				u = xl * yl

		# validation code
		p1 = self.lower_bound() * other.lower_bound()
		p2 = self.lower_bound() * other.upper_bound()
		p3 = self.upper_bound() * other.lower_bound()
		p4 = self.upper_bound() * other.upper_bound()
		cl = min(p1, p2, p3, p4)
		cu = max(p1, p2, p3, p4)
		if l == cl and u == cu:
			return Interval(l, u)
		else:
			raise AssertionError, 'wrong calc.' + str(Interval(cl, cu)) + str(Interval(l,u))



	def __div__(self, other):
		if other.upper_bound() * other.lower_bound() <= 0.0:
			raise StribingZeroError, 'cannot div'

		ol = 1/other.upper_bound()
		ou = 1/other.lower_bound()
		return self * Interval(ol, ou)

	def __str__(self):
		return "(" + str(self.lower_bound()) + "," + str(self.upper_bound()) + ")"

	def width(self):
		return (self.upper_bound() - self.lower_bound()) / 2.0


# 2.9
i1 = Interval(1, 2)
i2 = Interval(4, 15)
print("--- 2.9 ---")
print("add" + str(i1+i2))
print("sub" + str(i1-i2))
print("mul" + str(i1*i2))
print("div" + str(i1/i2))
print("i1           : " + str(i1))
print("i2           : " + str(i2))
print("(i2+i1).add  : " + str(i2+i1))
print("(i2+i1).width: " + str((i2+i1).width()))
print("(i2-i1).sub  : " + str(i2-i1))
print("(i2-i1).width: " + str((i2-i1).width()))
print("(i2*i1).mul  : " + str(i2*i1))
print("(i2*i1).width: " + str((i2*i1).width()))
print("(i2/i1).div  : " + str(i2/i1))
print("(i2/i1).width: " + str((i2/i1).width()))

# 2.10
#i1 = Interval(0, 2)
#i2 = Interval(4, 15)
## inverse : negative value is illegal when using the inverse function.
#print("i1           : " + str(i1))
#print("i2           : " + str(i2))
#print("(i2/i1).div  : " + str(i2/i1))

# 2.11
# expantion of min/max
# l u l u
# + + + +
# + + + - -> NG
# + + - +
# + + - -
# + - + + -> NG
# + - + - -> NG
# + - - + -> NG
# + - - - -> NG
# - + + +
# - + + - -> NG
# - + - + : min(lx * ly, lx * uy, ux * uy, ux * uy), max(lx * ly, lx * uy, ux * uy, ux * uy)
# - + - -
# - - + +
# - - + - -> NG
# - - - +
# - - - -
# 9 pattern except illegal pattern.


print("--- 2.11 ---")
print(Interval(3,7)*Interval(3,9))
print(Interval(3,7)*Interval(-3,9))
print(Interval(3,7)*Interval(-9,-3))
print(Interval(-3,7)*Interval(9,3))
print(Interval(-3,7)*Interval(-9,3))
print(Interval(-3,7)*Interval(-9,-3))
print(Interval(-3,-7)*Interval(9,3))
print(Interval(-3,-7)*Interval(-9,3))
print(Interval(-3,-7)*Interval(-9,-3))

