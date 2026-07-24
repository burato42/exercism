use std::{collections::HashMap, sync::LazyLock};

static BOTTLE_MAP: LazyLock<HashMap<u32, &str>> = LazyLock::new(|| {
    HashMap::from([
        (0, "No"),
        (1, "One"),
        (2, "Two"),
        (3, "Three"),
        (4, "Four"),
        (5, "Five"),
        (6, "Six"),
        (7, "Seven"),
        (8, "Eight"),
        (9, "Nine"),
        (10, "Ten"),
    ])
});

pub fn recite(start_bottles: u32, take_down: u32) -> String {
    (start_bottles - take_down + 1..=start_bottles)
        .rev()
        .map(|number: u32| {
            format!(
                "{curr} green bottle{s} hanging on the wall,\n\
        {curr} green bottle{s} hanging on the wall,\n\
        And if one green bottle should accidentally fall,\n\
        There'll be {next} green bottle{p} hanging on the wall.\n",
                curr = BOTTLE_MAP.get(&number).unwrap(),
                next = BOTTLE_MAP.get(&(number - 1)).unwrap().to_ascii_lowercase(),
                s = if number == 1 { "" } else { "s" },
                p = if number != 2 { "s" } else { "" }
            )
        })
        .collect::<Vec<String>>()
        .join("\n")
}
