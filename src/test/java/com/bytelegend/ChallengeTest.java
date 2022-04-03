package com.bytelegend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChallengeTest {
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[] {1}, Challenge.spiralOrder(new int[][] {{1}}));
        Assertions.assertArrayEquals(new int[] {1, 2}, Challenge.spiralOrder(new int[][] {{1, 2}}));
        Assertions.assertArrayEquals(
                new int[] {1, 2}, Challenge.spiralOrder(new int[][] {{1}, {2}}));
        Assertions.assertArrayEquals(
                new int[] {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10},
                Challenge.spiralOrder(
                        new int[][] {
                            {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
                        }));
        Assertions.assertArrayEquals(
                new int[] {1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11},
                Challenge.spiralOrder(
                        new int[][] {
                            {1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}
                        }));
    }
}
