#
# @lc app=leetcode id=37 lang=python3
#
# [37] Sudoku Solver
#

# @lc code=start
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        def backtracking(board):
            for row in range(9):
                for col in range(9):
                    if board[row][col] == ".":
                        for num in range(1, 10):
                            if isValid(row, col, board, num):
                                board[row][col] = str(num)
                                if backtracking(board):
                                    return True
                                board[row][col] = "."
                        return False
            # base case: if all cells filled return True
            return True

        def isValid(row, col, board, num):
            # vertical and horizontal
            for i in range(9):
                if board[i][col] == str(num) or board[row][i] == str(num):
                    return False
            # block
            startRow = (row // 3) * 3
            startCol = (col // 3) * 3
            for i in range(startRow, startRow + 3):
                for j in range(startCol, startCol + 3):
                    if board[i][j] == str(num):
                        return False
            return True

        backtracking(board)

# @lc code=end
