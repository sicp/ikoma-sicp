
# last_pair

class mytuple:

	def __init__(self, t):
		self.tpl = t

	def car(self):
		return self.tpl[0]

	def cdr(self):
		return self.tpl[1:]

	def last_pair(self):
		# return (self.tpl(-1),)
		l = len(self.tpl)
		return (self.tpl[l-1],)

	def __str__(self):
		return str(self.tpl)

t = mytuple((1,2))
print(t)
print(t.last_pair())
print(t.car())
print(t.cdr())
