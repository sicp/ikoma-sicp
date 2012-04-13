
def compose(func1, func2):
	return lambda x, f1=func1, f2=func2: f1(f2(x))

def dbl(func):
	return compose(func, func)

def inc(x):
	return x + 1

dinc = dbl(inc)
print(dbl(dbl(dbl))(inc)(5))
print(inc(1))
print(dinc(3))
