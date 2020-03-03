package com.lf.command;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 


@SuppressWarnings("serial")
public class CommandExecute extends JFrame {
	
	public static void main(String[] args) {
		new CommandExecute().setVisible(true);
	}
	
	public CommandExecute() {
		this("快捷面板 2.0 Release");
	}
	
	public CommandExecute(String string) {
		super(string);
		
		// x,y是针对桌面左上角
		this.setBounds(800, 500, 500, 300);
		// 点击关闭时，程序停止
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 流水布局，LEFT从左到右，垂直方向距离15、水平方向距离15
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		// 字体
		Font font = new Font("微软雅黑", Font.PLAIN, 16);
		
		
		// =============== 添加UI控件 =============== 
		
		//按钮
		JButton btn1 = new JButton("Eclipse");
		btn1.setFont(font);
		this.add(btn1);
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openEclipse();
			}
		};
		btn1.addActionListener(l);
		
		//占位
		JLabel label1 = new JLabel("                                                           <");
		this.add(label1);
		
		
		// 提交算法1 信息
		JTextField tf1 = new JTextField(20);
		tf1.setFont(font);
		tf1.setText("update");
		this.add(tf1);
		
		// 提交算法1 按钮
		JButton btn2 = new JButton("提交algorithm①");
		btn2.setFont(font);
		this.add(btn2);
		ActionListener l2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				git_push_algorithm1(tf1.getText());
			}
		};
		btn2.addActionListener(l2);
		
		
	}
	
	private void git_push_algorithm1(String string) {
		String s1 = "cd /Users/fengluo/Documents/算法①/algorithm①/fastlane";
		String s2 = "fastlane Manager msg:" + string;
		String[] cmd = {s1,s2};
        // 执行命令
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			proc.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void openEclipse() {
		
		String cmd = "open -n /Users/fengluo/eclipse/java-2019-03/Eclipse.app";
        // 执行命令
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			proc.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
	}
	

	
	
//	public static void main(String[] args) {
//        BufferedReader br = null;
//        try {
//            String cmd = "open -n /Users/fengluo/eclipse/java-2019-03/Eclipse.app";
//            // 执行命令
//            Process proc = Runtime.getRuntime().exec(cmd);
////            br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
////            String line;
////            while ((line = br.readLine()) != null) {
////                System.out.println(line);
////            }
//            
//            proc.waitFor();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
	
	
	// ping 并输出信息到控制台
//	public static void main(String[] args) {
//        BufferedReader br = null;
//        try {
//            String cmd = "ping 127.0.0.1";
//            // 执行dos命令并获取输出结果
//            Process proc = Runtime.getRuntime().exec(cmd);
//            br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
// 
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//            proc.waitFor();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
	
	
	// 打开浏览器，并跳转到首页
//	public static void main(String[] args) {
//        try {
////            String exeFullPathName = "C:/Program Files/Internet Explorer/IEXPLORE.EXE";
//            String exeFullPathName = "/Applications/Safari.app";
//            String message = "www.baidu.com";
//            String[] cmd = {exeFullPathName, message};
//            Process proc = Runtime.getRuntime().exec(cmd);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
	
	
//	public static void main(String[] args) {
//		CommandExecute obj = new CommandExecute();
//		String command = "ping www.baidu.com";
//		String output = obj.executeCommand(command, new File("/Users/fengluo/Desktop/123/"));
//		System.out.println(output);
//	}


	/*
	 * 执行dos命令的方法
	 * @param command 需要执行的dos命令
	 * @param file 指定开始执行的文件目录
	 * 
	 * @return true 转换成功，false 转换失败
	 */
	public static String executeCommand(String command, File file) {
		StringBuffer output = new StringBuffer();
		Process p;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		try {
			p = Runtime.getRuntime().exec(command, null, file);
			p.waitFor();
			inputStreamReader = new InputStreamReader(p.getInputStream(), "GBK");
			reader = new BufferedReader(inputStreamReader);
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
//			IOUtils.closeQuietly(reader);
//			IOUtils.closeQuietly(inputStreamReader);
		}
		System.out.println(output.toString());
		return output.toString();
	}
 
}
