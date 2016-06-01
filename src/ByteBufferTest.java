import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ByteBufferTest {
	 private static final int BSIZE = 1024;

	public static void main(String[] args) throws IOException {
		/** DEMO ONE*/
/*		// 创建一个capacity为256的ByteBuffer
		ByteBuffer buf = ByteBuffer.allocate(256);
		while (true) {
			// 从标准输入流读入一个字符
			int c = System.in.read();
			// 当读到输入流结束时，退出循环
			if (c == -1)
				break;
			// 把读入的字符写入ByteBuffer中
			buf.put((byte) c);
			// 当读完一行时，输出收集的字符
			if (c == '\n') {
				// 调用flip()使limit变为当前的position的值,position变为0,
				// 为接下来从ByteBuffer读取做准备
				buf.flip();
				// 构建一个byte数组
				byte[] content = new byte[buf.limit()];
				// 从ByteBuffer中读取数据到byte数组中
				buf.get(content);
				// 把byte数组的内容写到标准输出
				System.out.print(new String(content));
				// 调用clear()使position变为0,limit变为capacity的值，
				// 为接下来写入数据到ByteBuffer中做准备
				buf.clear();
			}
		}*/
		/**DEMO TWO */
/*		// TODO Auto-generated method stub
		 ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		 IntBuffer ib = bb.asIntBuffer(); // view buffer

		 // 存储int的数组
		 ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});

		 // 绝对位置读写
		 System.out.println(ib.get(3));

		 System.out.println("*******************************");
		 System.out.println(ib.limit());
		 ib.put(3, 1811);
		 ib.flip();
		 System.out.println(ib.limit());
		 System.out.println("*******************************");
		 ib.rewind();

		 while(ib.hasRemaining()){
		 int i = ib.get();
		 System.out.println(i);
		 }*/
		/** DEMO THREE*/
		 String str = "helloWorld";  
	        ByteBuffer buff  = ByteBuffer.wrap(str.getBytes());  
	        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());  
	        //读取两个字节  
	        buff.get();  
	        buff.get();  
	        System.out.println("position:"+ buff.position()+"\t limit:"+buff.limit());  
	        buff.mark();  
	        buff.get();  
	        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());  
	        buff.reset();
	        System.out.println("position:"+ buff.position()+"\t limit:"+buff.limit()); 
	        buff.flip();  
	        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());
		 }
	}

