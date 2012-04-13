
class Segment:

	def __init__(self, start, end):
		self.start = start
		self.end = end

	def start_segment(self):
		return self.start

	def end_segment(self):
		return self.end

class Point:

	def __init__(self, x, y):
		self.x = x
		self.y = y

	def to_str(self):
		s = "("
		s += str(self.x)
		s += ","
		s += str(self.y)
		s += ")"
		return s

def print_point(p):
	print(p.to_str())


def make_segment(start, end):
	return Segment(start, end)

def midpoint_segment(seg):
	start = seg.start_segment()
	end = seg.end_segment()
	mid_x = (start.x + end.x) / 2
	mid_y = (start.y + end.y) / 2
	return Point(mid_x, mid_y)

p1 = Point(1, 2)
p2 = Point(3, 4)
s = Segment(p1, p2)
print_point(midpoint_segment(s))
