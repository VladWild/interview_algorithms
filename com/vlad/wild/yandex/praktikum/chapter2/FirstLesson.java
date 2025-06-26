package vlad.wild.yandex.praktikum.chapter2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

/**
 * Допустим, мы проводим онлайн-конкурс работ молодых художников. Всего представлено
 * N работ, которые идентифицируются числами от 0 до N − 1 включительно.
 * Нужно поддержать 3 типа запроса:
 * Лайк работы с идентификатором id.
 * Дизлайк работы с идентификатором id.
 * Вернуть лучшие K работ.
 * Оценку работы будем считать просто: число лайков минус число дизлайков.
 */
public class FirstLesson {

    public static void main(String[] args) {

    }

    public static class Competition {
        private int[] scores;

        public Competition(int participantCount) {
            this.scores = new int[participantCount];
        }

        public void changeScore(int participantId, int change) {
            scores[participantId] += change;
        }

        public void like(int participantId) {
            changeScore(participantId, 1);
        }

        public void dislike(int participantId) {
            changeScore(participantId, -1);
        }

        /**
         * 1-ый элемент - это номер участника
         * 2-ой элемент - это количество набранных очков
         */
        public List<Integer> getBestWorks(int count) {
            List<int[]> scoreIdPairs = new ArrayList<>();

            for (int i = 0; i < scores.length; i++) {
                scoreIdPairs.add(new int[]{i, scores[i]});
            }

            //Если ссылки на массив те же самые, то сравниваем по номерам участников
            //Иначе по количеству набранных очков
            scoreIdPairs.sort((a, b) -> {
                if (b[0] != a[0]) return Integer.compare(b[0], a[0]);
                return Integer.compare(b[1], a[1]);
            });

            List<Integer> bestIds = new ArrayList<>();
            for (int i = 0; i < Math.min(count, scoreIdPairs.size()); i++) {
                bestIds.add(scoreIdPairs.get(i)[1]);
            }

            return bestIds;
        }
    }

    public static class Competition2 {

        private static class ParticipantStat implements Comparable<ParticipantStat> {
            int score;
            int id;

            ParticipantStat(int score, int id) {
                this.score = score;
                this.id = id;
            }

            @Override
            public int compareTo(ParticipantStat other) {
                // Сначала по score по возрастанию, потом по id по возрастанию
                if (this.score != other.score) {
                    return Integer.compare(this.score, other.score);
                }
                return Integer.compare(this.id, other.id);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof ParticipantStat)) return false;
                ParticipantStat other = (ParticipantStat) obj;
                return this.score == other.score && this.id == other.id;
            }

            @Override
            public int hashCode() {
                return Objects.hash(score, id);
            }
        }

        private int[] scores;
        private TreeSet<ParticipantStat> orderedWorks;

        public Competition2(int participantCount) {
            scores = new int[participantCount];
            orderedWorks = new TreeSet<>();
            for (int id = 0; id < participantCount; id++) {
                orderedWorks.add(new ParticipantStat(0, id));
            }
        }

        private void changeScore(int participantId, int change) {
            ParticipantStat oldStat = new ParticipantStat(scores[participantId], participantId);
            orderedWorks.remove(oldStat);

            scores[participantId] += change;

            ParticipantStat newStat = new ParticipantStat(scores[participantId], participantId);
            orderedWorks.add(newStat);
        }

        public void like(int participantId) {
            changeScore(participantId, 1);
        }

        public void dislike(int participantId) {
            changeScore(participantId, -1);
        }

        public List<Integer> getBestWorks(int count) {
            List<Integer> result = new ArrayList<>();
            Iterator<ParticipantStat> descending = orderedWorks.descendingIterator();
            while (descending.hasNext() && count-- > 0) {
                result.add(descending.next().id);
            }
            return result;
        }
    }
}
