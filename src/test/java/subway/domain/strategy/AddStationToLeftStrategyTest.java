package subway.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import subway.domain.Distance;
import subway.domain.Section;
import subway.domain.Station;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class AddStationToLeftStrategyTest {

    final AddStationStrategy addStationToLeftStrategy = new AddStationToLeftStrategy();

    @Test
    void 구간_사이에_왼쪽_방향으로_역을_추가한다() {
        // given
        List<Section> sections = new ArrayList<>(List.of(
                new Section("A", "B", 5),
                new Section("B", "C", 5)
        ));

        // when
        addStationToLeftStrategy.add(sections, new Station("B"), new Station("D"), new Distance(2));

        // then
        assertThat(sections).contains(
                new Section("A", "D", 3),
                new Section("D", "B", 2),
                new Section("B", "C", 5)
        );
    }

    @Test
    void 구간_왼쪽_끝에_역을_추가한다() {
        // given
        List<Section> sections = new ArrayList<>(List.of(
                new Section("A", "B", 5),
                new Section("B", "C", 5)
        ));

        // when
        addStationToLeftStrategy.add(sections, new Station("A"), new Station("D"), new Distance(2));

        // then
        assertThat(sections).contains(
                new Section("D", "A", 2),
                new Section("A", "B", 5),
                new Section("B", "C", 5)
        );
    }
}