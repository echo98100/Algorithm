class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        R = len(board)
        C = len(board[0])

        visited = [[False for _ in range(C)] for _ in range(R)]

        dr = [-1, 0, 0, 1]
        dc = [0, -1, 1, 0]

        def dfs(r, c, index):

            if (index == len(word)):
                return True

            if (r < 0 or r >= R or c < 0 or c >= C):
                return False

            if (visited[r][c]):
                return False

            if (board[r][c] != word[index]):
                return False

            visited[r][c] = True

            for i in range(4):
                if(dfs(r+dr[i], c+dc[i], index+1)):
                    return True

            visited[r][c] = False

            return False

        for r in range(R):
            for c in range(C):
                if (board[r][c] == word[0]):
                    if (dfs(r,c,0)):
                        return True

        return False


