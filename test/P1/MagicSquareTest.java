package P1;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MagicSquareTest {
    @Test
    public void testIsLegalMagicSquare() throws IOException {
        assertTrue(MagicSquare.isLegalMagicSquare("src/P1/txt/1.txt"));
        assertTrue(MagicSquare.isLegalMagicSquare("src/P1/txt/2.txt"));
        assertFalse(MagicSquare.isLegalMagicSquare("src/P1/txt/3.txt"));
        assertFalse(MagicSquare.isLegalMagicSquare("src/P1/txt/4.txt"));
        assertFalse(MagicSquare.isLegalMagicSquare("src/P1/txt/5.txt"));
    }

    // 考虑到非法输入已经在主函数中处理 这里使用的测试用例只有合法输入
    @Test
    public void testGenerateMagicSquare() throws IOException {
        assertTrue(MagicSquare.generateMagicSquare(7));
        assertTrue(MagicSquare.generateMagicSquare(5));
        assertTrue(MagicSquare.generateMagicSquare(13));
    }
}
