package exam.shopee;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        while(scanner.hasNext()){
            String word = scanner.nextLine();
			if(word.length()<=8&&word.length()>0){//如果字符串长度介~8之间
				StringBuffer medium = new StringBuffer(word);//将字符串(不可变长word转变为StringBuffer(可变长度的字符串)
				medium.append("0000000");//在字符串后面补全7个零
				String result = medium.substring(0, 8);//截取[0,8)个元素
				System.out.println(result);
			}else if(word.length()==0){
				break;//长度是零的直接跳出循环（因此在上面medium.append("0000000");只需补全7个零
			}else{
				for(int i=0;i<12;i++){//100%8约等12
					StringBuffer medium = new StringBuffer(word);
					String result = medium.substring(8*i, 8*(i+1));//获取剩余部分的元
					System.out.println(result);
					result = medium.substring(8*(i+1));
					if(result.length()<=8&&result.length()>0){
						StringBuffer next = new StringBuffer(result);//word.append("0000000");
						next.append("0000000");
						result = next.substring(0, 8);
						System.out.println(result);
						break;
				    }
               }
           }
        }
    }
}