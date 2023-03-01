package github.noargs.coroutinesdemo2

/**
 * A [coroutine] can invoke both suspending and non suspending functions
 *
 * But a [suspending] function can **only** be invoked from a coroutine
 * block or from another suspending function
 *
 */
class SuspendDemo {

    private fun firstFunction() {

    }

    private suspend fun secondFunction(){

    }
}