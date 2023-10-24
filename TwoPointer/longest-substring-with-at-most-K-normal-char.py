# Input : P = “normal”, Q = “00000000000000000000000000”, K=1
# Output : 1
# Explanation : In string Q all characters are normal.
# Hence, we can select any substring of length 1.

# Input : P = “giraffe”, Q = “01111001111111111011111111”, K=2
# Output : 3
# Explanation : Normal characters in P from Q are {a, f, g, r}.
# Therefore, possible substrings with at most 2 normal characters are {gir, ira, ffe}.
# The maximum length of all substring is 3.

def maxNormalSubstring(P, Q, K):
    if (K == 0):
        return 0
    # count of normal characters
    count = 0

    left, right = 0, 0
    N = len(P)
    ans = 0

    while (right < N):
        while (right < N and count <= K):

            # get position of character
            pos = ord(P[right]) - ord('a')

            # check if current character is normal
            if (Q[pos] == '0'):

                # check if normal characters
                # count exceeds K
                if (count + 1 > K):
                    break
                else:
                    count += 1

            right += 1

            # update answer with substring length
            if (count <= K):
                ans = max(ans, right - left)

        while left < right and count >= K:

            # get position of character
            pos = ord(P[left]) - ord('a')

            left += 1

            # check if character is
            # normal then decrement count
            if (Q[pos] == '0'):
                count -= 1

    return ans


p1 = "giraffe"
q1 = "01111001111111111011111111"
k1 = 1
print(maxNormalSubstring(p1, q1, k1))