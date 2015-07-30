package com.jshoperx.redis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

/**
 * redis对象序列化（抽象类接口）
 * 
 * @author Arvin.Cao
 *
 */
public abstract class SerializeTranscoder {
	protected static final Logger log = LoggerFactory
			.getLogger(SerializeTranscoder.class);

	public abstract byte[] serialize(Object value);

	public abstract Object deserialize(byte[] in);

	public void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
				log.info("Unable to close " + closeable, e);
			}
		}
	}
}
