
# last_pair

#class mytuple:
#
#	def __init__(self, t):
#		self.tpl = t
#
#	def car(self):
#		return self.tpl[0]
#
#	def cdr(self):
#		return self.tpl[1:]
#
#	def last_pair(self):
#		# return (self.tpl(-1),)
#		l = len(self.tpl)
#		return (self.tpl[l-1],)
#
#	def __str__(self):
#		return str(self.tpl)
#
#t = mytuple((1,2))
#print(t)
#print(t.last_pair())


def make_rlist(first, rest):
	 return (first, rest)

def first(s):
	return s[0]

def rest(s):
	return s[1]


empty_rlist = None
counts = make_rlist(1, make_rlist(2, make_rlist(3, make_rlist(4, empty_rlist))))
print(counts)
# (1, (2, (3, (4, None))))

def len_rlist(s):
	"""Return the length of recursive list s."""
	length = 0
	while s != empty_rlist:
		s, length = rest(s), length + 1
	return length


def getitem_rlist(s, i):
	"""Return the element at index i of recursive list s."""
	while i > 0:
		s, i = rest(s), i - 1
	return first(s)

print(len_rlist(counts))
print(getitem_rlist(counts, 1))

def last_pair(tpl):
	if tpl[0] == empty_rlist:
		return tpl

	while tpl[1] != None:
		tpl = rest(tpl)
	return (tpl[0],)

print(last_pair(counts))
print(last_pair((None,)))
