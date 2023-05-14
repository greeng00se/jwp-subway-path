package subway.domain;

import static subway.domain.Direction.LEFT;

import java.util.Objects;

public class Section {

    private final Station start;
    private final Station end;
    private final Distance distance;

    public Section(final String start, final String end, final int distance) {
        this(new Station(start), new Station(end), new Distance(distance));
    }

    public Section(final Station start, final Station end, final Distance distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public boolean contains(final Station station) {
        return start.equals(station) || end.equals(station);
    }

    public boolean containsAll(final Station start, final Station end) {
        return (this.start.equals(start) && this.end.equals(end))
                || (this.start.equals(end) && this.end.equals(start));
    }

    public boolean moreThanOrEqual(final Distance distance) {
        return this.distance.moreThanOrEqual(distance);
    }

    public boolean isStationExistsAtDirection(final Station station, final Direction direction) {
        if (direction == LEFT) {
            return start.equals(station);
        }
        return end.equals(station);
    }

    public Distance subtract(final Distance distance) {
        return this.distance.subtract(distance);
    }

    public Distance add(final Distance distance) {
        return this.distance.add(distance);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Section section = (Section) o;
        return Objects.equals(start, section.start) && Objects.equals(end, section.end)
                && Objects.equals(distance, section.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, distance);
    }

    @Override
    public String toString() {
        return "Section{" +
                "start=" + start +
                ", end=" + end +
                ", distance=" + distance +
                '}';
    }

    public Station getStart() {
        return start;
    }

    public String getStartName() {
        return start.getName();
    }

    public Station getEnd() {
        return end;
    }

    public String getEndName() {
        return end.getName();
    }

    public Distance getDistance() {
        return distance;
    }

    public Integer getDistanceValue() {
        return distance.getValue();
    }
}
