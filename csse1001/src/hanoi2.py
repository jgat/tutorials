class Towers(object):
    def __init__(self, n):
        self.n = n
        self.towers = {0: [n] + range(n-1, -1, -1), 1: [n], 2: [n]}

    def find(self, k):
        """which tower is block k on?"""
        for i, tower in self.towers.items():
            if k in tower:
                return i

    def __str__(self):
        s = ''
        for k in range(self.n):
            s += '    ' * self.find(k) + '*' + '\n'
        s += 'A   B   C\n'
        s += '---------'
        return s

    def move(self, from_, to):
        # perform checks on move validity:
        assert 0 <= from_ <= 2 and 0 <= to <= 2
        assert abs(from_ - to) == 1
        assert self.n > self.towers[from_][-1] < self.towers[to][-1]
        self.towers[to].append(self.towers[from_].pop())

    def solve(self):
        def helper(n, from_, to):
            if n == 0:
                # nothing to move
                return
            helper(n-1, from_, to)
            self.move(from_, 1)
            print self
            helper(n-1, to, from_)
            self.move(1, to)
            print self
            helper(n-1, from_, to)
        print self
        helper(self.n, 0, 2)

