package com.mumz.test.leet;

public class FloodFill {

    public static int[][] floodFill(
            int[][] image,
            int sr,
            int sc,
            int newColor
    ) {
        if (
                image == null ||
                image.length == 0 ||
                image[0].length == 0 ||
                sr > image.length ||
                sc > image[0].length ||
                image[sr][sc] == newColor
        )
            return image;

        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private static void dfs(
            int[][] image,
            int sr,
            int sc,
            int newColor,
            int oldColor
    ) {

        if (
                !checkBounds(sr - 1, sc, image) ||
                !shouldApplyNewColorToCell(sr - 1, sc, image, newColor, oldColor)
        )
            return;


        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr, sc - 1, newColor, oldColor);
        dfs(image, sr, sc + 1, newColor, oldColor);
    }

    private static boolean shouldApplyNewColorToCell(
            int row,
            int column,
            int[][] image,
            int newColor,
            int oldColor
    ) {
        return image[row][column] != newColor && image[row][column] == oldColor;
    }

    private static boolean checkBounds(
            int row,
            int column,
            int[][] image
    ) {
        return (
                row >= 0 && row < image.length &&
                column >= 0 && column < image[0].length
        );
    }

    public static void main(String[] args) {
        int[][] image = floodFill(
                new int[][]
                        {
                                {1, 1, 1},
                                {1, 1, 0},
                                {1, 0, 1}
                        },
                1, 1, 2
        );
        System.out.println(image);
    }
}
