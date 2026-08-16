use std::io::{Read, Result, Write};

pub struct ReadStats<R> {
    wrapped: R,
    position: usize,
    reads_count: usize,
}

impl<R: Read> ReadStats<R> {
    pub fn new(wrapped: R) -> ReadStats<R> {
        Self {
            wrapped,
            position: 0,
            reads_count: 0,
        }
    }

    pub fn get_ref(&self) -> &R {
        &self.wrapped
    }

    pub fn bytes_through(&self) -> usize {
        self.position
    }

    pub fn reads(&self) -> usize {
        self.reads_count
    }
}

impl<R: Read> Read for ReadStats<R> {
    fn read(&mut self, buf: &mut [u8]) -> Result<usize> {
        let n = self.wrapped.read(buf)?;
        self.position += n;
        self.reads_count += 1;
        Ok(n)
    }
}

pub struct WriteStats<W> {
    wrapped: W,
    position: usize,
    write_count: usize,
}

impl<W: Write> WriteStats<W> {
    pub fn new(wrapped: W) -> WriteStats<W> {
        Self {
            wrapped,
            position: 0,
            write_count: 0,
        }
    }

    pub fn get_ref(&self) -> &W {
        &self.wrapped
    }

    pub fn bytes_through(&self) -> usize {
        self.position
    }

    pub fn writes(&self) -> usize {
        self.write_count
    }
}

impl<W: Write> Write for WriteStats<W> {
    fn write(&mut self, buf: &[u8]) -> Result<usize> {
        let n = self.wrapped.write(buf)?;
        self.position += n;
        self.write_count += 1;
        Ok(n)
    }

    fn flush(&mut self) -> Result<()> {
        self.wrapped.flush()?;
        Ok(())
    }
}
