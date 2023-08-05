#
# @lc app=leetcode id=51 lang=python3
#
# [51] N-Queens
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def isValid(row: int, col: int, board: List[str]) -> bool:
            for i in range(row):
                if board[i][col] == "Q":
                    return False

            i = row - 1
            j = col - 1
            while i >= 0 and j >= 0:
                if board[i][j] == "Q":
                    return False
                i -= 1
                j -= 1

            i = row - 1
            j = col + 1
            while i >= 0 and j < n:
                if board[i][j] == "Q":
                    return False
                i -= 1
                j += 1

            return True

        def backtracking(curRow: int, board: List[str]) -> None:
            if curRow == n:
                res.append(board[:])
                return

            for curCol in range(n):
                if isValid(curRow, curCol, board):
                    board[curRow] = board[curRow][:curCol] + "Q" + board[curRow][curCol + 1:]
                    backtracking(curRow + 1, board)
                    board[curRow] = board[curRow][:curCol] + "." + board[curRow][curCol + 1:]


        res = []
        chessBoard = ["." * n for _ in range(n)]
        # print(board)
        backtracking(0, chessBoard)
        return res
# @lc code=end
