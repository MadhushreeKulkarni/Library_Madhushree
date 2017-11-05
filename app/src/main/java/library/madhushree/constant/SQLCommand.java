/**
 * SQL commands
 * Including select/delete/update/insert
 */
package library.madhushree.constant;

public abstract class SQLCommand
{
    //list all data in books table
    public static String QUERY_1 = "select lbcallnum, lbtitle from LibBook ";
    //List the call numbers of books with the title ‘Organizations’
    public static String QUERY_2 = "select lbcallnum from libbook where lbtitle = 'Organizations'";
    //List the average and maximum cofine
    public static String QUERY_3 = "select avg(COFine), max(COFine) from CheckOut";
    //List the student name who has not returned the books
    public static String QUERY_4 = "select STID from CheckOut where CoReturned = 'N'";
    //List Student name and all books in student and checkout by student name
    public static String QUERY_5 = "select STName, LBCallNum from Student, CheckOut where Student.STID = CheckOut.STID Order By STName";
    //List the books with title num a1
    public static String QUERY_6 = "select lbtitle from libBook where lbcallnum = 'a1'";
    //List the call numbers of books and count from CheckOut
    public static String QUERY_7 = "select CheckOut.STID, SUM(COFine) from Checkout Group by CheckOut.STID";
    //List STID, sum of cofine group by STID.

    public static String RETURN_BOOK = "update checkout set coreturned=? where stid=? and lbcallnum=?";

    public static String CHECK_BOOK = "insert into checkout(stid,lbcallnum,coduedate,coreturned) values(?,?,?,?)";

    //checkout summary
    public static String CHECKOUT_SUMMARY = "select strftime('%m',coduedate) as month,count(*) as total from checkout where strftime('%Y',coduedate)='2011' group by month order by total desc";

}
