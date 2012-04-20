import fractions;

class Rational:
	def __init__(self, num=0, den=1):
		#print('num:' + str(num) + ', den:' + str(den))
		if (num < 0 and den < 0) or (num > 0 and den > 0):
			self.numer = abs(num)
			self.denom = abs(den)
		else:
			self.numer = -abs(num)
			self.denom = abs(den)

	def to_str(self):
		return str(self.numer) + '/' + str(self.denom)

	def __cmp__(self, other):
		return cmp(self.numer * other.denom, self.numer * other.denom)


def make_rat(x, y):
	g = abs(fractions.gcd(x, y))
	r = Rational(x/g, y/g)
	return r

def add_rat(x, y):
	numer = x.numer * y.denom + y.numer * x.denom
	denom = x.denom * y.denom
	return make_rat(numer, denom)

def sub_rat(x, y):
	numer = x.numer * y.denom - y.numer * x.denom
	denom = x.denom * y.denom
	return make_rat(numer, denom)

def mul_rat(x, y):
	numer = x.numer * y.numer
	denom = x.denom * y.denom
	return make_rat(numer, denom)

def div_rat(x, y):
	numer = x.numer * y.denom
	denom = x.denom * y.numer
	return make_rat(numer, denom)


def one_half():
	return make_rat(1,2)

def one_third():
	return make_rat(1,3)

print(one_half().to_str())
print(one_third().to_str())
print(add_rat(one_half(), one_third()).to_str())
print(mul_rat(one_half(), one_third()).to_str())
print(add_rat(one_third(), one_third()).to_str())
print(make_rat(1,2).to_str())
print(make_rat(-1,2).to_str())
print(make_rat(1,-2).to_str())
print(make_rat(-1,-2).to_str())
