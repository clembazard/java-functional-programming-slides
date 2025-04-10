UnaryOperator<Double> log = (value) -> Math.log(value);
UnaryOperator<Double> sqrt = (value) -> Math.sqrt(value);
UnaryOperator<Double> logThenSqrt = sqrt.compose(log);
logger.log(Level.INFO, String.valueOf(logThenSqrt.apply(3.14)));
// Output: 1.06

UnaryOperator<Double> sqrtThenLog = sqrt.andThen(log);
logger.log(Level.INFO, String.valueOf(sqrtThenLog.apply(3.14)));
// Output: 0.57