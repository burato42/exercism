pub mod graph {
    use std::collections::HashMap;

use crate::graph::graph_items::node::Node;


    pub mod graph_items {

        pub mod node {
            use std::collections::HashMap;

            #[derive(Clone, Debug, PartialEq)]
            pub struct Node<'a> {
                pub value: &'a str,
                attrs: HashMap<&'a str, &'a str>,
            }

            impl <'a> Node<'a> {
                pub fn new(value: &'a str) -> Self {
                    Self { value: value, attrs: HashMap::new() }
                }

                pub fn with_attrs(mut self, attr_list: &[(&'a str, &'a str)]) -> Self {
                    for (name, value) in attr_list {
                        self.attrs.insert(*name, *value);
                    }
                    self
                }

                pub fn attr(&self, key: &str) -> Option<&'a str> {
                    self.attrs.get(key).copied()
                }
            }
        }

        pub mod edge {
            use std::collections::HashMap;
            
            #[derive(Clone, Debug, PartialEq)]
            pub struct Edge<'a> {
                from: &'a str,
                to: &'a str,
                attrs: HashMap<&'a str, &'a str>,
            }

            impl <'a> Edge<'a> {
                pub fn new(from: &'a str, to: &'a str) -> Self {
                    Self { from: from, to: to, attrs: HashMap::new() }
                }
                
                pub fn with_attrs(mut self, attr_list: &[(&'a str, &'a str)]) -> Self {
                    for (name, value) in attr_list {
                        self.attrs.insert(*name, *value);
                    }
                    self
                }

                pub fn attr(&self, key: &str) -> Option<&'a str> {
                    self.attrs.get(key).copied()
                }
            }
        }

}

    pub struct Graph<'a> {
        pub nodes: Vec<graph_items::node::Node<'a>>,
        pub edges: Vec<graph_items::edge::Edge<'a>>,
        pub attrs: HashMap<&'a str, &'a str>,
    }

    impl <'a> Graph<'a> {
        pub fn new() -> Self {
            Self { nodes: vec![], edges: vec![], attrs: HashMap::new()}
        }

        pub fn with_attrs(mut self, attr_list: &[(&'a str, &'a str)]) -> Self {
            for (name, value) in attr_list {
                self.attrs.insert(*name, *value);
            }
            self
        }

        pub fn attr(&self, key: &str) -> Option<&'a str> {
            self.attrs.get(key).copied()
        }

        pub fn with_nodes(mut self, _nodes: &[graph_items::node::Node<'a>]) -> Self {
            self.nodes = _nodes.to_vec();
            self
        }

        pub fn with_edges(mut self, _edges: &[graph_items::edge::Edge<'a>]) -> Self {
            self.edges = _edges.to_vec();
            self
        }

        pub fn node(&self, value: &str) -> Option<&graph_items::node::Node<'a>> {
            self.nodes.iter().find(|n| n.value == value)
        }

    }
}
