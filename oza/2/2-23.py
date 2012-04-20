

def for_each(proc, lst):
	l = len(lst)
	i = 0
	while i < l:
		proc(lst[i])
		i += 1

# only run in python 3.x, because print(x) is not expression but statement in python2
p = lambda x: print(x)
tpl = (1, 2, 3, 4, 5, 6)
for_each(p, tpl)
