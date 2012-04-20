#!/usr/bin/env python
# 1 = 2^0 * 3^0 = (0, 0)
# 2 = 2^1 * 3^0 = (1, 0)
# 3 = 2^2 * 3^0 = (2, 0)
# 36 = 2^2 * 3^2 = (2, 3)


def cons(x, y):
	return (2 ** x) * (3 ** y)

def car(val):
	x = 0
	while val % 2 == 0:
		x += 1
		val /= 2

	return x


def cdr(val):
	y = 0
	while val % 3 == 0:
		y += 1
		val /= 3

	return y

val = cons(2, 3)
print("result of cons:" + str(val))
print("result of car :" + str(car(val)))
print("result of cdr :" + str(cdr(val)))

val = cons(20, 3)
print("result of cons:" + str(val))
print("result of car :" + str(car(val)))
print("result of cdr :" + str(cdr(val)))


# (cons 2, 3)
# result of cons:108 result of car :2
# result of cdr :3
# (cons 20, 3)
# result of cons:28311552
# result of car :20
# result of cdr :3
