package org.medipractice.clientui.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@EqualsAndHashCode(of = {"id", "value", "date"}, callSuper = false)
@ToString(of = {"id", "value", "date"})
@NoArgsConstructor
public class DataValueBean extends Auditable<String> {

    private UUID id;

    private UUID parentId;

    private String value;

    private LocalDateTime date = LocalDateTime.now();

    public DataValueBean(String dataValue) {
        this.value = dataValue;
    }

    public DataValueBean(DataValueBean dataValueBean) {
        this.parentId = dataValueBean.getParentId();
        this.value = dataValueBean.getValue();
        this.date = dataValueBean.getDate();
    }

    public DataValueBean(String dataValue, LocalDateTime dataDate) {
        this.value = dataValue;
        this.date = dataDate;
    }

}
