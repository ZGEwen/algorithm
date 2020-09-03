package test;

/**
 * @Classname Points
 * @Created by zgw
 * @Date 2020-08-29 11:15
 * @Description 离质心最小的点的下标
 */
public class Points {
    public static void main(String[] args) {
        String[] points={"1,1","2,2","1,2","1,3"};
        System.out.print(get_index(points));
    }
    public static int get_index(String[] points){
        Long xc=0L,yc=0L;
        for (String s:points
        ) {
            String[] ss = s.split(",");
            xc+=Long.parseLong(ss[0]);
            yc+=Long.parseLong(ss[1]);
        }
        xc=xc/points.length;
        yc=yc/points.length;
        System.out.println(xc+","+yc);
        long min=Long.MAX_VALUE;
        int retIndex=0;
        int index=0;
        for (String s:points
        ) {
            String[] ss = s.split(",");
            long x2 = (long) Math.pow(xc - Long.parseLong(ss[0]),2);
            long y2= (long) Math.pow(yc - Long.parseLong(ss[1]),2);
            if (min>(x2+y2)){
                min=x2+y2;
                retIndex=index;
            }
            index++;
        }
        return retIndex;
    }
}
