package P3;

import org.junit.Test;

import static org.junit.Assert.*;

public class FriendshipGraphTest {
    /**
     * 小规模 稀疏图
     * 无任何重复、异常输入 进行距离大于0/等于0/不连通的情况下的计算
     */
    @Test
    public void GraphTest1(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");

        friendshipGraph.addVertex(rachel);
        friendshipGraph.addVertex(ross);
        friendshipGraph.addVertex(ben);
        friendshipGraph.addVertex(kramer);

        friendshipGraph.addEdge(rachel,ross);
        friendshipGraph.addEdge(ross, rachel);
        friendshipGraph.addEdge(ross, ben);
        friendshipGraph.addEdge(ben, ross);

        assertEquals(1,friendshipGraph.getDistance(rachel,ross));
        // should be 1
        assertEquals(2,friendshipGraph.getDistance(rachel,ben));
        // should be 2
        assertEquals(0,friendshipGraph.getDistance(rachel,rachel));
        // should be 0
        assertEquals(-1,friendshipGraph.getDistance(rachel,kramer));
        // cannot reach, should be -1
    }
    /**
     * 小规模 稠密图
     * 无任何重复、异常输入 进行距离大于0/等于0/不连通的情况下的计算
     */
    @Test
    public void GraphTest2(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person p0 = new Person("Alpha");
        Person p1 = new Person("Beta");
        Person p2 = new Person("Charlies");
        Person p3 = new Person("Delta");
        Person p4 = new Person("Echo");
        Person p5 = new Person("Foxtrot");
        Person p6 = new Person("Golf");

        friendshipGraph.addVertex(p0);
        friendshipGraph.addVertex(p1);
        friendshipGraph.addVertex(p2);
        friendshipGraph.addVertex(p3);
        friendshipGraph.addVertex(p4);
        friendshipGraph.addVertex(p5);
        friendshipGraph.addVertex(p6);

        friendshipGraph.addEdge(p0,p1);
        friendshipGraph.addEdge(p1,p0);
        friendshipGraph.addEdge(p0,p2);
        friendshipGraph.addEdge(p2,p0);
        friendshipGraph.addEdge(p0,p3);
        friendshipGraph.addEdge(p3,p0);
        friendshipGraph.addEdge(p0,p4);
        friendshipGraph.addEdge(p4,p0);
        friendshipGraph.addEdge(p5,p6);
        friendshipGraph.addEdge(p6,p5);
        friendshipGraph.addEdge(p1,p4);
        friendshipGraph.addEdge(p4,p1);
        friendshipGraph.addEdge(p1,p2);
        friendshipGraph.addEdge(p2,p1);
        friendshipGraph.addEdge(p4,p2);
        friendshipGraph.addEdge(p2,p4);

        assertEquals(-1,friendshipGraph.getDistance(p6,p0));
        assertEquals(2,friendshipGraph.getDistance(p4,p3));
        assertEquals(1,friendshipGraph.getDistance(p5,p6));
        assertEquals(0,friendshipGraph.getDistance(p2,p2));



    }
    /**
     * 大规模 稀疏图
     * 无任何重复、异常输入 进行距离大于0/等于0/不连通的情况下的计算
     */
    @Test
    public void GraphTest3(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person p0 = new Person("Alpha");
        Person p1 = new Person("Beta");
        Person p2 = new Person("Charlies");
        Person p3 = new Person("Delta");
        Person p4 = new Person("Echo");
        Person p5 = new Person("Foxtrot");
        Person p6 = new Person("Golf");
        Person p7 = new Person("Hotel");
        Person p8 = new Person("India");
        Person p9 = new Person("Juliet");
        Person p10 = new Person("Kilo");
        Person p11 = new Person("Lima");
        Person p12 = new Person("Mike");
        Person p13 = new Person("November");
        Person p14 = new Person("Oscar");
        Person p15 = new Person("Papa");
        Person p16 = new Person("Quebec");
        Person p17 = new Person("Romeo");
        Person p18 = new Person("Sierra");
        Person p19 = new Person("Tango");
        Person p20 = new Person("Uniform");

        friendshipGraph.addVertex(p0);
        friendshipGraph.addVertex(p1);
        friendshipGraph.addVertex(p2);
        friendshipGraph.addVertex(p3);
        friendshipGraph.addVertex(p4);
        friendshipGraph.addVertex(p5);
        friendshipGraph.addVertex(p6);
        friendshipGraph.addVertex(p7);
        friendshipGraph.addVertex(p8);
        friendshipGraph.addVertex(p9);
        friendshipGraph.addVertex(p10);
        friendshipGraph.addVertex(p11);
        friendshipGraph.addVertex(p12);
        friendshipGraph.addVertex(p13);
        friendshipGraph.addVertex(p14);
        friendshipGraph.addVertex(p15);
        friendshipGraph.addVertex(p16);
        friendshipGraph.addVertex(p17);
        friendshipGraph.addVertex(p18);
        friendshipGraph.addVertex(p19);
        friendshipGraph.addVertex(p20);

        friendshipGraph.addEdge(p2,p17);
        friendshipGraph.addEdge(p17,p2);
        friendshipGraph.addEdge(p19,p17);
        friendshipGraph.addEdge(p17,p19);
        friendshipGraph.addEdge(p17,p14);
        friendshipGraph.addEdge(p14,p17);
        friendshipGraph.addEdge(p14,p7);
        friendshipGraph.addEdge(p7,p14);
        friendshipGraph.addEdge(p0,p7);
        friendshipGraph.addEdge(p7,p0);
        friendshipGraph.addEdge(p5,p1);
        friendshipGraph.addEdge(p1,p5);
        friendshipGraph.addEdge(p6,p8);
        friendshipGraph.addEdge(p8,p6);
        friendshipGraph.addEdge(p12,p4);
        friendshipGraph.addEdge(p4,p12);
        friendshipGraph.addEdge(p4,p2);
        friendshipGraph.addEdge(p2,p4);
        friendshipGraph.addEdge(p2,p17);
        friendshipGraph.addEdge(p17,p2);
        friendshipGraph.addEdge(p11,p9);
        friendshipGraph.addEdge(p9,p11);
        friendshipGraph.addEdge(p19,p3);
        friendshipGraph.addEdge(p3,p19);

        assertEquals(-1,friendshipGraph.getDistance(p3,p13));
        assertEquals(-1,friendshipGraph.getDistance(p0,p11));
        assertEquals(5,friendshipGraph.getDistance(p12,p3));
        assertEquals(0,friendshipGraph.getDistance(p5,p5));
    }
    /**
     * 大规模 稠密图
     * 无任何重复、异常输入 进行距离大于0/等于0/不连通的情况下的计算
     */
    @Test
    public void GraphTest4(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person p0 = new Person("Alpha");
        Person p1 = new Person("Beta");
        Person p2 = new Person("Charlies");
        Person p3 = new Person("Delta");
        Person p4 = new Person("Echo");
        Person p5 = new Person("Foxtrot");
        Person p6 = new Person("Golf");
        Person p7 = new Person("Hotel");
        Person p8 = new Person("India");
        Person p9 = new Person("Juliet");
        Person p10 = new Person("Kilo");
        Person p11 = new Person("Lima");
        Person p12 = new Person("Mike");
        Person p13 = new Person("November");
        Person p14 = new Person("Oscar");
        Person p15 = new Person("Papa");
        Person p16 = new Person("Quebec");
        Person p17 = new Person("Romeo");
        Person p18 = new Person("Sierra");
        Person p19 = new Person("Tango");
        Person p20 = new Person("Uniform");

        friendshipGraph.addVertex(p0);
        friendshipGraph.addVertex(p1);
        friendshipGraph.addVertex(p2);
        friendshipGraph.addVertex(p3);
        friendshipGraph.addVertex(p4);
        friendshipGraph.addVertex(p5);
        friendshipGraph.addVertex(p6);
        friendshipGraph.addVertex(p7);
        friendshipGraph.addVertex(p8);
        friendshipGraph.addVertex(p9);
        friendshipGraph.addVertex(p10);
        friendshipGraph.addVertex(p11);
        friendshipGraph.addVertex(p12);
        friendshipGraph.addVertex(p13);
        friendshipGraph.addVertex(p14);
        friendshipGraph.addVertex(p15);
        friendshipGraph.addVertex(p16);
        friendshipGraph.addVertex(p17);
        friendshipGraph.addVertex(p18);
        friendshipGraph.addVertex(p19);
        friendshipGraph.addVertex(p20);

        // 26 edges, e^2 > n
        friendshipGraph.addEdge(p16,p17);
        friendshipGraph.addEdge(p17,p16);
        friendshipGraph.addEdge(p17,p3);
        friendshipGraph.addEdge(p3,p17);
        friendshipGraph.addEdge(p16,p3);
        friendshipGraph.addEdge(p3,p16);
        friendshipGraph.addEdge(p3,p2);
        friendshipGraph.addEdge(p2,p3);
        friendshipGraph.addEdge(p16,p2);
        friendshipGraph.addEdge(p2,p16);
        friendshipGraph.addEdge(p2,p15);
        friendshipGraph.addEdge(p15,p2);
        friendshipGraph.addEdge(p15,p16);
        friendshipGraph.addEdge(p16,p15);
        friendshipGraph.addEdge(p16,p0);
        friendshipGraph.addEdge(p0,p16);
        friendshipGraph.addEdge(p4,p5);
        friendshipGraph.addEdge(p5,p4);
        friendshipGraph.addEdge(p2,p0);
        friendshipGraph.addEdge(p0,p2);
        friendshipGraph.addEdge(p0,p7);
        friendshipGraph.addEdge(p7,p0);
        friendshipGraph.addEdge(p7,p13);
        friendshipGraph.addEdge(p13,p7);
        friendshipGraph.addEdge(p8,p9);
        friendshipGraph.addEdge(p9,p8);
        friendshipGraph.addEdge(p13,p9);
        friendshipGraph.addEdge(p9,p13);
        friendshipGraph.addEdge(p4,p10);
        friendshipGraph.addEdge(p10,p4);
        friendshipGraph.addEdge(p11,p1);
        friendshipGraph.addEdge(p1,p11);
        friendshipGraph.addEdge(p1,p6);
        friendshipGraph.addEdge(p6,p1);
        friendshipGraph.addEdge(p6,p14);
        friendshipGraph.addEdge(p14,p6);
        friendshipGraph.addEdge(p14,p3);
        friendshipGraph.addEdge(p3,p14);
        friendshipGraph.addEdge(p12,p14);
        friendshipGraph.addEdge(p14,p12);
        friendshipGraph.addEdge(p14,p18);
        friendshipGraph.addEdge(p18,p14);
        friendshipGraph.addEdge(p11,p19);
        friendshipGraph.addEdge(p19,p11);
        friendshipGraph.addEdge(p19,p6);
        friendshipGraph.addEdge(p6,p19);
        friendshipGraph.addEdge(p6,p20);
        friendshipGraph.addEdge(p20,p6);
        friendshipGraph.addEdge(p17,p2);
        friendshipGraph.addEdge(p2,p17);
        friendshipGraph.addEdge(p2,p13);
        friendshipGraph.addEdge(p13,p2);


        assertEquals(-1,friendshipGraph.getDistance(p5,p3));
        assertEquals(4,friendshipGraph.getDistance(p11,p12));
        assertEquals(0,friendshipGraph.getDistance(p4,p4));
        assertEquals(5,friendshipGraph.getDistance(p7,p18));
    }

    /**
     * 特殊情景测试：所有的顶点在一环上
     * 无任何重复、异常输入 进行距离大于0/等于0/不连通的情况下的计算
     */
    @Test
    public void GraphTest5()
    {
        FriendshipGraph graph = new FriendshipGraph();
        Person p1 = new Person("P1");
        Person p2 = new Person("P2");
        Person p3 = new Person("P3");
        Person p4 = new Person("P4");
        Person p5 = new Person("P5");
        Person p6 = new Person("P6");
        Person p7 = new Person("P7");

        graph.addVertex(p1);
        graph.addVertex(p2);
        graph.addVertex(p3);
        graph.addVertex(p4);
        graph.addVertex(p5);
        graph.addVertex(p6);
        graph.addVertex(p7);

        graph.addEdge(p1,p2);
        graph.addEdge(p2,p1);
        graph.addEdge(p2,p3);
        graph.addEdge(p3,p2);
        graph.addEdge(p1,p4);
        graph.addEdge(p4,p1);
        graph.addEdge(p4,p5);
        graph.addEdge(p5,p4);
        graph.addEdge(p5,p6);
        graph.addEdge(p6,p5);
        graph.addEdge(p7,p6);
        graph.addEdge(p6,p7);
        graph.addEdge(p3,p7);
        graph.addEdge(p7,p3);

        assertEquals(2,graph.getDistance(p1,p3));
        assertEquals(3,graph.getDistance(p4,p3));
    }

    /**
     * 有重复名字 小规模图 不存在自连边
     */
    @Test
    public void IllegalTest1(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person alpha = new Person("alpha");
        Person beta = new Person("beta");
        Person charlies = new Person("charlies");
        Person delta = new Person("alpha");

        assertTrue(friendshipGraph.addVertex(alpha));
        assertTrue(friendshipGraph.addVertex(beta));
        assertTrue(friendshipGraph.addVertex(charlies));

        // should return False for not having a unique name.
        assertFalse(friendshipGraph.addVertex(delta));

        assertTrue(friendshipGraph.addEdge(alpha,beta));
        assertTrue(friendshipGraph.addEdge(beta,alpha));
        assertTrue(friendshipGraph.addEdge(charlies,beta));
        assertTrue(friendshipGraph.addEdge(beta,charlies));
    }
    /**
     * 有重复名字 大规模图 不存在自连边
     */
    @Test
    public void IllegalTest2(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person a = new Person("A");
        Person b = new Person("B");
        Person c = new Person("C");
        Person d = new Person("D");
        Person e = new Person("E");
        Person f = new Person("F");
        Person g = new Person("G");
        Person h = new Person("H");
        Person i = new Person("I");
        Person j = new Person("J");
        Person k = new Person("K");
        Person l = new Person("L");
        Person m = new Person("M");
        Person n = new Person("N");
        Person a1 = new Person("A");
        Person m1 = new Person("M");
        Person g1 = new Person("G");

        assertTrue(friendshipGraph.addVertex(a));
        assertTrue(friendshipGraph.addVertex(b));
        assertTrue(friendshipGraph.addVertex(c));
        assertTrue(friendshipGraph.addVertex(d));
        assertTrue(friendshipGraph.addVertex(e));
        assertTrue(friendshipGraph.addVertex(f));
        assertTrue(friendshipGraph.addVertex(g));
        assertTrue(friendshipGraph.addVertex(h));
        assertTrue(friendshipGraph.addVertex(i));
        assertTrue(friendshipGraph.addVertex(j));
        assertTrue(friendshipGraph.addVertex(k));
        assertTrue(friendshipGraph.addVertex(l));
        assertTrue(friendshipGraph.addVertex(m));
        assertTrue(friendshipGraph.addVertex(n));


        assertFalse(friendshipGraph.addVertex(a1));
        assertFalse(friendshipGraph.addVertex(g1));
        assertFalse(friendshipGraph.addVertex(m1));

        assertTrue(friendshipGraph.addEdge(a,e));
        assertTrue(friendshipGraph.addEdge(e,a));
        assertTrue(friendshipGraph.addEdge(m,n));
        assertTrue(friendshipGraph.addEdge(n,m));
    }
    /**
     * 有重复名字 大规模图 有自连边
     */
    @Test
    public void IllegalTest3() {
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person p0 = new Person("Alpha");
        Person p1 = new Person("Beta");
        Person p2 = new Person("Charlies");
        Person p3 = new Person("Delta");
        Person p4 = new Person("Echo");
        Person p5 = new Person("Foxtrot");
        Person p6 = new Person("Golf");
        Person p7 = new Person("Hotel");
        Person p8 = new Person("India");
        Person p9 = new Person("Juliet");
        Person p10 = new Person("Kilo");
        Person p11 = new Person("Lima");
        Person p12 = new Person("Mike");
        Person p13 = new Person("November");
        Person p14 = new Person("Oscar");
        Person p15 = new Person("Papa");
        Person p16 = new Person("Quebec");
        Person p17 = new Person("Romeo");
        Person p18 = new Person("Sierra");
        Person p19 = new Person("Tango");
        Person p20 = new Person("Uniform");
        Person p1_ = new Person("Beta");
        Person p9_ = new Person("Juliet");

        assertTrue(friendshipGraph.addVertex(p0));
        assertTrue(friendshipGraph.addVertex(p1));
        assertTrue(friendshipGraph.addVertex(p2));
        assertTrue(friendshipGraph.addVertex(p3));
        assertTrue(friendshipGraph.addVertex(p4));
        assertTrue(friendshipGraph.addVertex(p5));
        assertTrue(friendshipGraph.addVertex(p6));
        assertTrue(friendshipGraph.addVertex(p7));
        assertTrue(friendshipGraph.addVertex(p8));
        assertTrue(friendshipGraph.addVertex(p9));
        assertTrue(friendshipGraph.addVertex(p10));
        assertTrue(friendshipGraph.addVertex(p11));
        assertTrue(friendshipGraph.addVertex(p12));
        assertTrue(friendshipGraph.addVertex(p13));
        assertTrue(friendshipGraph.addVertex(p14));
        assertTrue(friendshipGraph.addVertex(p15));
        assertTrue(friendshipGraph.addVertex(p16));
        assertTrue(friendshipGraph.addVertex(p17));
        assertTrue(friendshipGraph.addVertex(p18));
        assertTrue(friendshipGraph.addVertex(p19));
        assertTrue(friendshipGraph.addVertex(p20));

        // should return False for not having a unique name.
        assertFalse(friendshipGraph.addVertex(p1_));
        assertFalse(friendshipGraph.addVertex(p9_));

        assertTrue(friendshipGraph.addEdge(p2,p17));
        assertTrue(friendshipGraph.addEdge(p17,p2));
        assertTrue(friendshipGraph.addEdge(p19,p17));
        assertTrue(friendshipGraph.addEdge(p17,p19));
        assertTrue(friendshipGraph.addEdge(p17,p14));
        assertTrue(friendshipGraph.addEdge(p14,p17));
        assertTrue(friendshipGraph.addEdge(p14,p7));
        assertTrue(friendshipGraph.addEdge(p7,p14));
        assertTrue(friendshipGraph.addEdge(p0,p7));
        assertTrue(friendshipGraph.addEdge(p7,p0));
        assertTrue(friendshipGraph.addEdge(p5,p1));
        assertTrue(friendshipGraph.addEdge(p1,p5));
        assertTrue(friendshipGraph.addEdge(p6,p8));
        assertTrue(friendshipGraph.addEdge(p8,p6));
        assertTrue(friendshipGraph.addEdge(p12,p4));
        assertTrue(friendshipGraph.addEdge(p4,p12));
        assertTrue(friendshipGraph.addEdge(p4,p2));
        assertTrue(friendshipGraph.addEdge(p2,p4));
        assertTrue(friendshipGraph.addEdge(p2,p17));
        assertTrue(friendshipGraph.addEdge(p17,p2));
        assertTrue(friendshipGraph.addEdge(p11,p9));
        assertTrue(friendshipGraph.addEdge(p9,p11));
        assertTrue(friendshipGraph.addEdge(p19,p3));
        assertTrue(friendshipGraph.addEdge(p3,p19));

        // should throw IllegalArgumentException for a self-connect edge.
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(p19,p19));
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(p3,p3));
    }
    /**
     * 有重复名字 小规模图 有自连边
     */
    @Test
    public void IllegalTest4(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person alpha = new Person("Alpha");
        Person beta = new Person("Beta");
        Person charlies = new Person("Charlies");
        Person delta = new Person("Delta");
        Person echo = new Person("Alpha");

        assertTrue(friendshipGraph.addVertex(alpha));
        assertTrue(friendshipGraph.addVertex(beta));
        assertTrue(friendshipGraph.addVertex(charlies));
        assertTrue(friendshipGraph.addVertex(delta));

        // should return False for not having a unique name.
        assertFalse(friendshipGraph.addVertex(echo));

        assertTrue(friendshipGraph.addEdge(alpha,beta));
        assertTrue(friendshipGraph.addEdge(beta,alpha));
        assertTrue(friendshipGraph.addEdge(charlies,beta));
        assertTrue(friendshipGraph.addEdge(beta,charlies));

        // should throw IllegalArgumentException for a self-connect edge.
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(delta,delta));
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(charlies,charlies));
    }
    /**
     * 无重复名字 大规模图 有自连边
     */
    @Test
    public void IllegalTest5(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person p0 = new Person("Alpha");
        Person p1 = new Person("Beta");
        Person p2 = new Person("Charlies");
        Person p3 = new Person("Delta");
        Person p4 = new Person("Echo");
        Person p5 = new Person("Foxtrot");
        Person p6 = new Person("Golf");
        Person p7 = new Person("Hotel");
        Person p8 = new Person("India");
        Person p9 = new Person("Juliet");
        Person p10 = new Person("Kilo");
        Person p11 = new Person("Lima");
        Person p12 = new Person("Mike");
        Person p13 = new Person("November");
        Person p14 = new Person("Oscar");
        Person p15 = new Person("Papa");
        Person p16 = new Person("Quebec");
        Person p17 = new Person("Romeo");
        Person p18 = new Person("Sierra");
        Person p19 = new Person("Tango");
        Person p20 = new Person("Uniform");

        assertTrue(friendshipGraph.addVertex(p0));
        assertTrue(friendshipGraph.addVertex(p1));
        assertTrue(friendshipGraph.addVertex(p2));
        assertTrue(friendshipGraph.addVertex(p3));
        assertTrue(friendshipGraph.addVertex(p4));
        assertTrue(friendshipGraph.addVertex(p5));
        assertTrue(friendshipGraph.addVertex(p6));
        assertTrue(friendshipGraph.addVertex(p7));
        assertTrue(friendshipGraph.addVertex(p8));
        assertTrue(friendshipGraph.addVertex(p9));
        assertTrue(friendshipGraph.addVertex(p10));
        assertTrue(friendshipGraph.addVertex(p11));
        assertTrue(friendshipGraph.addVertex(p12));
        assertTrue(friendshipGraph.addVertex(p13));
        assertTrue(friendshipGraph.addVertex(p14));
        assertTrue(friendshipGraph.addVertex(p15));
        assertTrue(friendshipGraph.addVertex(p16));
        assertTrue(friendshipGraph.addVertex(p17));
        assertTrue(friendshipGraph.addVertex(p18));
        assertTrue(friendshipGraph.addVertex(p19));
        assertTrue(friendshipGraph.addVertex(p20));

        assertTrue(friendshipGraph.addEdge(p2,p17));
        assertTrue(friendshipGraph.addEdge(p17,p2));
        assertTrue(friendshipGraph.addEdge(p19,p17));
        assertTrue(friendshipGraph.addEdge(p17,p19));
        assertTrue(friendshipGraph.addEdge(p17,p14));
        assertTrue(friendshipGraph.addEdge(p14,p17));
        assertTrue(friendshipGraph.addEdge(p14,p7));
        assertTrue(friendshipGraph.addEdge(p7,p14));
        assertTrue(friendshipGraph.addEdge(p0,p7));
        assertTrue(friendshipGraph.addEdge(p7,p0));
        assertTrue(friendshipGraph.addEdge(p5,p1));
        assertTrue(friendshipGraph.addEdge(p1,p5));
        assertTrue(friendshipGraph.addEdge(p6,p8));
        assertTrue(friendshipGraph.addEdge(p8,p6));
        assertTrue(friendshipGraph.addEdge(p12,p4));
        assertTrue(friendshipGraph.addEdge(p4,p12));
        assertTrue(friendshipGraph.addEdge(p4,p2));
        assertTrue(friendshipGraph.addEdge(p2,p4));
        assertTrue(friendshipGraph.addEdge(p2,p17));
        assertTrue(friendshipGraph.addEdge(p17,p2));
        assertTrue(friendshipGraph.addEdge(p11,p9));
        assertTrue(friendshipGraph.addEdge(p9,p11));
        assertTrue(friendshipGraph.addEdge(p19,p3));
        assertTrue(friendshipGraph.addEdge(p3,p19));
        assertTrue(friendshipGraph.addEdge(p7,p9));
        assertTrue(friendshipGraph.addEdge(p9,p7));

        // should throw IllegalArgumentException for a self-connect edge.
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(p12,p12));
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(p8,p8));
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(p1,p1));
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(p3,p3));
    }
    /**
     * 无重复名字 小规模图 有自连边
     */
    @Test
    public void IllegalTest6(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person alpha = new Person("Alpha");
        Person beta = new Person("Beta");
        Person charlies = new Person("Charlies");
        Person delta = new Person("Delta");
        Person echo = new Person("Echo");
        Person foxtrot = new Person("Foxtrot");

        assertTrue(friendshipGraph.addVertex(alpha));
        assertTrue(friendshipGraph.addVertex(beta));
        assertTrue(friendshipGraph.addVertex(charlies));
        assertTrue(friendshipGraph.addVertex(delta));
        assertTrue(friendshipGraph.addVertex(echo));
        assertTrue(friendshipGraph.addVertex(foxtrot));

        assertTrue(friendshipGraph.addEdge(alpha,beta));
        assertTrue(friendshipGraph.addEdge(beta,alpha));
        assertTrue(friendshipGraph.addEdge(charlies,beta));
        assertTrue(friendshipGraph.addEdge(beta,charlies));
        assertTrue(friendshipGraph.addEdge(foxtrot,delta));
        assertTrue(friendshipGraph.addEdge(delta,foxtrot));

        // should throw IllegalArgumentException for a self-connect edge.
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(delta,delta));
        assertThrows(IllegalArgumentException.class,()->friendshipGraph.addEdge(charlies,charlies));
    }
    /**
     * 单向连通下getDistance方法运行效果检测
     */
    @Test
    public void DirectedTest(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");

        friendshipGraph.addVertex(rachel);
        friendshipGraph.addVertex(ross);
        friendshipGraph.addVertex(ben);
        friendshipGraph.addVertex(kramer);

        friendshipGraph.addEdge(rachel,ross);
        friendshipGraph.addEdge(ross, ben);

        assertEquals(1,friendshipGraph.getDistance(rachel,ross));
        // should be 1
        assertEquals(2,friendshipGraph.getDistance(rachel,ben));
        // should be 2
        assertEquals(-1,friendshipGraph.getDistance(ben,ross));
        // should be -1
        assertEquals(-1,friendshipGraph.getDistance(ben,rachel));
        // should be -1
    }
    /**
     * 验证重复添加边不影响FriendshipGraph类
     */
    @Test
    public void AddEdgeAgain(){
        FriendshipGraph friendshipGraph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");

        friendshipGraph.addVertex(rachel);
        friendshipGraph.addVertex(ross);
        friendshipGraph.addVertex(ben);
        friendshipGraph.addVertex(kramer);

        friendshipGraph.addEdge(rachel,ross);
        friendshipGraph.addEdge(ross, rachel);
        friendshipGraph.addEdge(ross, ben);
        friendshipGraph.addEdge(ben, ross);
        assertTrue(friendshipGraph.addEdge(ross,ben));
        assertTrue(friendshipGraph.addEdge(rachel,ross));
    }
}
