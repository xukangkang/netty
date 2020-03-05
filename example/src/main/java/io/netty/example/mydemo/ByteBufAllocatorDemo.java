package io.netty.example.mydemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import org.junit.jupiter.api.Test;

public class ByteBufAllocatorDemo {
    @Test
    public void testPageAllocator(){
        int page = 1024 * 8;
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        ByteBuf byteBuf = allocator.directBuffer(4 * page);
        byteBuf.release();
        allocator.directBuffer(4 * page);
    }
    @Test
    public void testSubpageAllocator(){
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        ByteBuf byteBuf = allocator.directBuffer(16);
        byteBuf.release();
    }
    @Test
    public void testSubpageUnpoolAllocator(){
        UnpooledByteBufAllocator allocator = UnpooledByteBufAllocator.DEFAULT;
        ByteBuf byteBuf = allocator.directBuffer(16);
        byteBuf.release();
    }

}
