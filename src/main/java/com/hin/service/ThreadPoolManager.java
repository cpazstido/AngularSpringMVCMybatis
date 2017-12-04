package com.hin.service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
	
	private static ThreadPoolManager sThreadPoolManager;

	public static ThreadPoolManager getInstance() {
		if (sThreadPoolManager == null) {
			synchronized (ThreadPoolManager.class) {
				if (sThreadPoolManager == null)
					sThreadPoolManager = new ThreadPoolManager();
			}
		}
		return sThreadPoolManager;
	}
	
	// �̳߳�ά���̵߳���������
	private static final int SIZE_CORE_POOL = 15;

	// �̳߳�ά���̵߳��������
	private static final int SIZE_MAX_POOL = 15;

	

	
	/**
	 * �̳߳�
	 * 
	 * @param corePoolSize
	 *            - ������������߳��������������̡߳�
	 * @param maximumPoolSize
	 *            - �������������߳�����
	 * @param keepAliveTime
	 *            - ���߳������ں���ʱ����Ϊ��ֹǰ����Ŀ����̵߳ȴ���������ʱ�䡣
	 * @param unit
	 *            - keepAliveTime ������ʱ�䵥λ��
	 * @param workQueue
	 *            - ִ��ǰ���ڱ�������Ķ��С��˶��н��ɱ��� execute �����ύ�� Runnable ����
	 * @param handler
	 *            - ���ڳ����̷߳�Χ�Ͷ���������ʹִ�б�����ʱ��ʹ�õĴ������
	 */
	// ʵ�ʾ���newFixedThreadPool ����һ�������̳߳أ��ɿ����߳���󲢷������������̻߳��ڶ����еȴ�
	private final ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(SIZE_CORE_POOL, SIZE_MAX_POOL, 0L,
			TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

	/*
	 * �����췽���������η���Ϊ˽�У���ֹ����ʵ������
	 */
	private ThreadPoolManager() {
	}

	/*
	 * ���̳߳س�ʼ���������߳�����
	 */
	public void perpare() {
		if (mThreadPool.isShutdown() && !mThreadPool.prestartCoreThread()) {
			@SuppressWarnings("unused")
			int startThread = mThreadPool.prestartAllCoreThreads();
		}
	}

	/*
	 * ���̳߳���������񷽷�
	 */
	public void addExecuteTask(Runnable task) {
		if (task != null) {
			mThreadPool.execute(task);
		}
	}

	/*
	 * �ж��Ƿ������һ������
	 */
	protected boolean isTaskEnd() {
		if (mThreadPool.getActiveCount() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * ��ȡ�����С
	 */
	public int getQueue() {
		return mThreadPool.getQueue().size();
	}

	/*
	 * ��ȡ�̳߳��е��߳���Ŀ
	 */
	public int getPoolSize() {
		return mThreadPool.getPoolSize();
	}

	/*
	 * ��ȡ����ɵ�������
	 */
	public long getCompletedTaskCount() {
		return mThreadPool.getCompletedTaskCount();
	}

	/*
	 * �ر��̳߳أ����ڽ����µ����񣬻���ѽ��ܵ�����ִ����
	 */
	public void shutdown() {
		mThreadPool.shutdown();
		while(true){
			if(mThreadPool.isTerminated()){
				 System.out.println("���е����̶߳������ˣ�");  
				break;
			}
			
		}
	
	}
}
