package GCJ2020;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class Pogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            String xst = Long.toBinaryString(x);
            String yst = Long.toBinaryString(y);
            String t = "1";
            char one = t.charAt(0);
//            System.out.println(xst + " " + yst);
            StringBuilder res = new StringBuilder();
            int pos = 0;
            if ((x&y)==0) {
                while (x != 0 || y != 0) {
                    if (xst.length() > pos && yst.length() > pos) {
                        if (yst.charAt(pos) != one && xst.charAt(pos) != one) {
                            System.out.println("IMPOSSIBLE");
                            break;
                        }
                        if (yst.charAt(pos) == one && xst.charAt(pos) == one) {
                            System.out.println("IMPOSSIBLE");
                            break;
                        }
                    }
                    if (xst.length() > pos) {
                        if (xst.charAt(pos) == one) {
                            if (x > 0) {
                                res.append("E");
                                x -= Math.pow(2, pos);
                            } else  {
                                res.append("W");
                                x += Math.pow(2, pos);

                            }
                        }
                    }
                    if (yst.length() > pos) {
                        if (yst.charAt(pos) == one) {
                            if (y > 0) {
                                res.append("N");
                                y -= Math.pow(2, pos);
                            } else {
                                res.append("S");
                                y += Math.pow(2, pos);
                            }

                        }
                    }
                    pos++;
                    if (pos > yst.length() && pos > xst.length()) {
                        System.out.println(res);
                        break;
                    }
                }
            } else if ((x&(-y))==0){
                y = -y;
                while (x != 0 || y != 0) {
                    if (xst.length() > pos && yst.length() > pos) {
                        if (yst.charAt(pos) != one && xst.charAt(pos) != one) {
                            System.out.println("IMPOSSIBLE dupe 0");
                            break;
                        }
                        if (yst.charAt(pos) == one && xst.charAt(pos) == one) {
                            System.out.println("IMPOSSIBLE dupe 1 at " + pos);
                            break;
                        }
                    }
                    if (xst.length() > pos) {
                        if (xst.charAt(pos) == one) {
                            if (x > 0) {
                                res.append("E");
                                x -= Math.pow(2, pos);
                            } else  {
                                res.append("W");
                                x += Math.pow(2, pos);

                            }
                            System.out.println(x);
                        }
                    }
                    if (yst.length() > pos) {
                        if (yst.charAt(pos) == one) {
                            if (y > 0) {
                                res.append("N");
                                y -= Math.pow(2, pos);
                            } else {
                                res.append("S");
                                y += Math.pow(2, pos);
                            }

                        }
                        System.out.println(y);
                    }
                    pos++;
                    if (pos > yst.length() && pos > xst.length()) {
                        System.out.println(res);
                        break;
                    }
                }
            }
            else if (((-x)&y)==0){
                x = -x;
                while (x != 0 || y != 0) {
                    if (xst.length() > pos && yst.length() > pos) {
                        if (yst.charAt(pos) != one && xst.charAt(pos) != one) {
                            System.out.println("IMPOSSIBLE");
                            break;
                        }
                        if (yst.charAt(pos) == one && xst.charAt(pos) == one) {
                            System.out.println("IMPOSSIBLE");
                            break;
                        }
                    }
                    if (xst.length() > pos) {
                        if (xst.charAt(pos) == one) {
                            if (x > 0) {
                                res.append("E");
                                x -= Math.pow(2, pos);
                            } else  {
                                res.append("W");
                                x += Math.pow(2, pos);

                            }
                        }
                    }
                    if (yst.length() > pos) {
                        if (yst.charAt(pos) == one) {
                            if (y > 0) {
                                res.append("N");
                                y -= Math.pow(2, pos);
                            } else {
                                res.append("S");
                                y += Math.pow(2, pos);
                            }

                        }
                    }
                    pos++;
                    if (pos > yst.length() && pos > xst.length()) {
                        System.out.println(res);
                        break;
                    }
                }
            }
            else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
