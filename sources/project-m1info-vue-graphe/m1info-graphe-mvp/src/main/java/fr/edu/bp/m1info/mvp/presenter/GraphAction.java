package fr.edu.bp.m1info.mvp.presenter;

import fr.edu.bp.m1info.mvp.view.UIMain;
import fr.edu.bp.m1info.structure.geometric.ShapeGeometric;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.EdgeDecorator;
import fr.edu.bp.m1info.structure.geometric.graph.shape.edge.EdgeName;
import fr.edu.bp.m1info.structure.graph.DirectedGraph;
import fr.edu.bp.m1info.structure.graph.FlowNetworkGraph;
import fr.edu.bp.m1info.structure.graph.Graph;
import fr.edu.bp.m1info.structure.graph.UnDirectedGraph;
import fr.edu.bp.m1info.structure.graph.edge.Arc;
import fr.edu.bp.m1info.structure.graph.edge.Edge;
import fr.edu.bp.m1info.structure.graph.edge.IEdge;
import fr.edu.bp.m1info.structure.graph.edge.decorator.EdgeFlow;
import fr.edu.bp.m1info.structure.graph.vertex.Vertex;
import fr.edu.bp.m1info.swing.common.SwingUtils;
import fr.edu.bp.m1info.swing.design.GraphCanvas;
import fr.edu.bp.m1info.swing.events.*;
import graph.algorithm.IterativeView;
import graph.algorithm.network.DinicFlowNetwork;
import graph.algorithm.network.EdmondsKarp;
import graph.algorithm.network.FordFulkerson;
import graph.algorithm.path.BellmanFordPath;
import graph.algorithm.path.BreadthFirstPath;
import graph.algorithm.path.DepthFirstPath;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class GraphAction {

    private GraphCanvas canvas;
    private Graph graph;
    private UIMain view;
    private javax.swing.JScrollPane spanel;

    public GraphAction(UIMain view, int optionGraphe) {

        if (optionGraphe == NewGraphPresenter.GRAPHE_NON_ORIENTE) {
            graph = new UnDirectedGraph<Edge, Vertex>() {
            };
            canvas = new GraphCanvas<Edge, Vertex>(graph);
        } else {
            if (optionGraphe == NewGraphPresenter.GRAPHE_ORIENTE) {
                graph = new DirectedGraph<Arc, Vertex>() {
                };
                canvas = new GraphCanvas<Arc, Vertex>(graph);
            }else{
                if (optionGraphe == NewGraphPresenter.GRAPHE_NETWORK) {
                    graph = new FlowNetworkGraph<EdgeFlow,Vertex>() {};
                    canvas = new GraphCanvas<EdgeFlow, Vertex>(graph);
                }
            }
        }
        if (optionGraphe != -1) {
            createComponent(view);
        }
    }

    private void createComponent(UIMain view) {

        for (Component cp : view.getJpPrincipal().getComponents()) {
            view.getJpPrincipal().remove(cp);
        }

        spanel = new javax.swing.JScrollPane();
        spanel.setBackground(new java.awt.Color(255, 255, 255));
        view.getJpPrincipal().add(spanel, java.awt.BorderLayout.CENTER);
        spanel.setViewportView(canvas);
        view.ennableBtnGraphe(true);
        view.ennableBtnDroit(false);
//            if (optionGraphe == NewGraphPresenter.GRAPHE_ORIENTE) {
//                view.getBtnContracter().setEnabled(false);
//                view.getJmiContrater().setEnabled(false);
//                view.getBtnGAuto().setEnabled(false);
//            }
        view.getJmGraphe().setEnabled(true);
        view.getJmGeometric().setEnabled(false);

        view.revalidate();
        view.repaint();
        this.view = view;
        actions();

    }


    public GraphAction(UIMain view, GraphCanvas canvas) {
        this.canvas = canvas;
        this.graph = canvas.getGraph();
        createComponent(view);
    }

    public void addVertexAction() {
        MouseListener addVertexAction = new AddVertexListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseListener(addVertexAction);
    }

    public void movedVertexAction() {
        MouseAdapter movedAction = new MoveVertexListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseMotionListener(movedAction);
        canvas.addMouseListener(movedAction);
    }

    public void addEdgeAction() {
        MouseAdapter edgeAction = new AddEdgeListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseMotionListener(edgeAction);
        canvas.addMouseListener(edgeAction);
    }

    public void deleteEdgeAction() {
        MouseAdapter deEdgeAction = new DeleteEdgeListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseMotionListener(deEdgeAction);
        canvas.addMouseListener(deEdgeAction);
    }

    public void contrationEdgeAction() {
        MouseAdapter coEdgeAction = new ContrationEdgeListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseMotionListener(coEdgeAction);
        canvas.addMouseListener(coEdgeAction);
    }

    public void separateEdgeAction() {
        MouseListener seVertexAction = new SeparateVertexListener(canvas);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseListener(seVertexAction);
    }

    public void generateGrapheAction(JButton jComponent) {
        AbstractAction geVertexAction = new GenerateGrapheAction(canvas, spanel);
        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        jComponent.addActionListener(geVertexAction);
    }

    public void executeBreadFirstSearch() {
        final BreadthFirstPath bfs = new BreadthFirstPath(canvas.getGraph(), (Vertex) graph.getVertex().get(0), (IterativeView) canvas);
        Thread runner = new Thread(
                new Runnable() {
                    public void run() {
                        bfs.execute();
                    }
                }
        );
        runner.start();
    }

    public void executeDepthFirstPath() {
        final DepthFirstPath dfp = new DepthFirstPath(canvas.getGraph(), (Vertex) graph.getVertex().get(0), (IterativeView) canvas);
        Thread runner = new Thread(
                new Runnable() {
                    public void run() {
                        dfp.execute();
                    }
                }
        );
        runner.start();
    }

    private void executeBellmanFord() {
        final BellmanFordPath bfp = new BellmanFordPath(canvas.getGraph(), (Vertex) graph.getVertex().get(0), (IterativeView) canvas);
        Thread runner = new Thread(
                new Runnable() {
                    public void run() {
                        bfp.execute();
                    }
                }
        );
        runner.start();
    }


    private void executeFordFulkerson() {
        ((FlowNetworkGraph)graph).setSource((Vertex) graph.getVertex().get(0));
        ((FlowNetworkGraph)graph).setSink((Vertex) graph.getVertex().get(graph.sizeVertex()-1));
        final FordFulkerson ffn = new FordFulkerson<EdgeFlow, Vertex>((FlowNetworkGraph<EdgeFlow, Vertex>) canvas.getGraph(),
                (IterativeView) canvas);
        Thread runner = new Thread(
                new Runnable() {
                    public void run() {
                        ffn.execute();
                        JOptionPane.showMessageDialog(view,"Flot maximum :"+ffn.getFlowMaximal(),"Graphz Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        );
        runner.start();
    }

    private void executeEdmondsKarp() {
        ((FlowNetworkGraph)graph).setSource((Vertex) graph.getVertex().get(0));
        ((FlowNetworkGraph)graph).setSink((Vertex) graph.getVertex().get(graph.sizeVertex()-1));
        final EdmondsKarp ekn = new EdmondsKarp<EdgeFlow, Vertex>((FlowNetworkGraph<EdgeFlow, Vertex>) canvas.getGraph(),
                (IterativeView) canvas);
        Thread runner = new Thread(
                new Runnable() {
                    public void run() {
                        ekn.execute();
                        JOptionPane.showMessageDialog(view,"Flot maximum :"+ekn.getFlowMaximal(),"Graphz Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        );
        runner.start();
    }

    private void executeDinics() {
        ((FlowNetworkGraph)graph).setSource((Vertex) graph.getVertex().get(0));
        ((FlowNetworkGraph)graph).setSink((Vertex) graph.getVertex().get(graph.sizeVertex()-1));
        final DinicFlowNetwork dnc = new DinicFlowNetwork<EdgeFlow, Vertex>((FlowNetworkGraph<EdgeFlow, Vertex>) canvas.getGraph(),
                (IterativeView) canvas);
        Thread runner = new Thread(
                new Runnable() {
                    public void run() {
                        dnc.execute();
                        JOptionPane.showMessageDialog(view,"Flot maximum :"+dnc.getFlowMaximal(),"Graphz Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        );
        runner.start();
    }

    private void mouseListenerSearchShape() {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Iterator it = canvas.getGraph().getEdges().iterator();
                while (it.hasNext()) {
                    IEdge edge = (IEdge) it.next();
                    fr.edu.bp.m1info.structure.geometric.graph.shape.Shape shape = edge.getShape();
                    if (shape instanceof EdgeDecorator) {
                        EdgeDecorator decorator = ((EdgeDecorator) shape);
                        if (decorator.childEdgeShape() instanceof EdgeName) {
                            ShapeGeometric shapeGeometric = decorator.childEdgeShape().shape();
                            if (shapeGeometric.contains(e.getX(), e.getY())) {
                                String value = JOptionPane.showInputDialog(view.getParent(), "Weigh:");
                                int w = Integer.parseInt(value);
                                edge.setWeight(w);
                                ((EdgeName)decorator.childEdgeShape()).setMessage(value);
                                //((Message) shapeGeometric).setMessage(value);
                                canvas.repaint();
                                break;
                            }
                        }
                    }
                }
            }
        });

    }


    public void actions() {

        this.view.getBtnASommets().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        addVertexAction();
                        mouseListenerSearchShape();
                    }
                });

        this.view.getBtnSSommet().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        deleteVertexAction();
                    }
                });

        this.view.getBtnAArete().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        addEdgeAction();
                        mouseListenerSearchShape();
                    }
                });

        this.view.getBtnSArete().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        deleteEdgeAction();
                    }
                });

        this.view.getBtnDesplacer().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        movedVertexAction();
                    }
                });


        this.view.getBtnSepare().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        separateEdgeAction();
                    }
                });

        this.view.getBtnContracter().addActionListener(
                new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        contrationEdgeAction();
                    }
                });

        this.view.getBtnEffacer().addActionListener(new ClearGraphAction(canvas));

        this.view.getJmiAddNode().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVertexAction();
            }
        });

        this.view.getJmiDelNode().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVertexAction();
            }
        });

        this.view.getJmiAddEdge().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEdgeAction();
            }
        });

        this.view.getJmiDelEdge().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEdgeAction();
            }
        });

        this.view.getJmiMoveNode().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movedVertexAction();
            }
        });

        this.view.getJmiSepare().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                separateEdgeAction();
            }
        });

        this.view.getJmiContrater().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrationEdgeAction();
            }
        });

        this.view.getJmiCleanGraph().addActionListener(new ClearGraphAction(canvas));

        this.view.getJmiBFS().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeBreadFirstSearch();
            }
        });

        this.view.getJmiDFS().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeDepthFirstPath();
            }
        });

        this.view.getJmiBellmanFord().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeBellmanFord();
            }
        });

        this.view.getJmiFordFulkerson().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeFordFulkerson();
            }
        });

        this.view.getJmiDinicFlowNetWork().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeDinics();
            }
        });

        this.view.getJmiEdmondsKarp().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeEdmondsKarp();
            }
        });

        this.generateGrapheAction(view.getBtnGAuto());

    }


    public void deleteVertexAction() {
        MouseListener deVertexAction = new DeleteVertexListener(canvas);

        SwingUtils.removeListenerMouse(MouseListener.class, canvas);
        SwingUtils.removeListenerMouse(MouseMotionListener.class, canvas);

        canvas.addMouseListener(deVertexAction);
    }

    public Graph getGraph() {
        return graph;
    }

    public GraphCanvas getCanvas() {
        return canvas;
    }

    public JScrollPane getSpanel() {
        return spanel;
    }
}
