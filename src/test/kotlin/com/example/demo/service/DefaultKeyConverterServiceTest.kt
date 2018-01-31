package com.example.demo.service

import org.junit.Test
import java.util.*

class DefaultKeyConverterServiceTest {

    val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustConvertibleBothWays() {
        val rand = Random()
        for (l in 0..1000L) {
            val initialId = Math.abs(rand.nextLong())
            val link = service.idToKey(initialId)
            val id = service.keyToId(link)
            org.junit.Assert.assertEquals(initialId, id)
        }

    }
}