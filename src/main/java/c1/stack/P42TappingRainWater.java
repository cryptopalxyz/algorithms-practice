package c1.stack;

import java.util.Deque;
import java.util.LinkedList;

public class P42TappingRainWater {
    class Rect {
        int width;
        int height;
        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
    public int trap(int[] heights) {
        Deque<Rect> s = new LinkedList<>();
        int ans = 0;
        for (int height: heights) {
            int accumulatedWidth = 0;
            while (!s.isEmpty() && s.peek().height <= height) {
                int bottom = s.peek().height;
                accumulatedWidth += s.peek().width;
                s.pop();
                if (s.isEmpty()) continue; //水从左边流走了
                //以bottom为底的横块水，最高可以到up（左右两侧高度的min）
                int up = Math.min(height, s.peek().height);
                ans += accumulatedWidth * (up - bottom);

            }
            s.push(new Rect(accumulatedWidth + 1, height));

        }
        return ans;
    }
}
