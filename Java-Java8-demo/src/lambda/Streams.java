package lambda;

public class Streams  {

   public enum TaskStatus {
        OPEN, CLOSED
    }
    public static final class Task {
        private final TaskStatus status;
        private final Integer points;

        Task( final TaskStatus status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public TaskStatus getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }
}